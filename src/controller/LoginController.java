package controller;

import datastorage.AccountDAO;
import datastorage.MovieDAO;
import domain.Account;
import domain.MovieCollection;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class LoginController extends Controller {
    private LoginView view;
    private Account account;

    public LoginController(LoginView view)
    {
        super();
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        View view;
        switch (e.getActionCommand()) {
            case "Register":
                view = MainFrame.getMainFrame().getViewMap().get(ViewName.REGISTER);
                if (view == null) {
                    view = new RegisterView();
                }
                MainFrame.getMainFrame().setView(view);
                break;
            case "Login":
                if(login()) {
                    //Add account to mainframe ModelMap
                    MainFrame.getMainFrame().addModel("account", account);
                    view = MainFrame.getMainFrame().getViewMap().get(ViewName.MOVIECOLLECTION);
                    if (view == null) {
                        MovieDAO movieDAO = new MovieDAO();
                        MovieCollection mcCollection = movieDAO.getActualMovies();
                        view = new MovieCollectionView(mcCollection);
                    }
                    MainFrame.getMainFrame().setView(view);
                }
                break;
        }
    }

    private boolean login() {
        boolean ret = true;
        AccountDAO accountDAO = new AccountDAO();
        account = accountDAO.login(view.getTfusername().getText(), view.getPfPassword().getPassword());
        if(account == null)
        {
            JOptionPane.showMessageDialog(MainFrame.getMainFrame().getContentPane(), "Gegevens onjuist!", "Onjuiste gegevens", JOptionPane.ERROR_MESSAGE);
            ret = false;
        }
        return ret;
    }
}
