package controller;

import datastorage.AccountDAO;
import datastorage.MovieDAO;
import domain.Account;
import domain.MovieCollection;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoginController extends Controller {
    private LoginView view;
    private Account account;

    public LoginController(LoginView view) {
        super();
        this.view = view;
    }

    /**
     * Executed on action event for components that are registered on the corresponding view
     *
     * @param e the ActionEvent created when user click on the component
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        View view;
        switch (e.getActionCommand()) {
            case "Register":
                view = MainFrame.getMainFrame().getViewMap().get(ViewName.REGISTER);
                if (view == null) {
                    view = new RegisterView();
                }
                MainFrame.getMainFrame().setTitle("MovieMasters - Registreren");
                MainFrame.getMainFrame().setView(view);
                break;
            case "Login":
                if (login()) {
                    //Add account to mainframe ModelMap
                    MainFrame.getMainFrame().setCachedUser(account);
                    view = MainFrame.getMainFrame().getViewMap().get(ViewName.MOVIECOLLECTION);
                    if (view == null) {
                        MovieDAO movieDAO = new MovieDAO();
                        MovieCollection mcCollection = movieDAO.getActualMovies();
                        view = new MovieCollectionView(mcCollection);
                    }
                    MainFrame.getMainFrame().setTitle("MovieMasters - Film overzicht");
                    MainFrame.getMainFrame().setView(view);
                } else {
                    JOptionPane.showMessageDialog(MainFrame.getMainFrame().getContentPane(), "Gegevens onjuist!", "Onjuiste gegevens", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }
    }

    /**
     * Validates the login credentials
     *
     * @return a boolean, true when the user entered valid credentials, false otherwise
     */
    private boolean login() {
        AccountDAO accountDAO = new AccountDAO();
        account = accountDAO.login(view.getTfusername().getText(), view.getPfPassword().getPassword());
        return account != null;
    }
}
