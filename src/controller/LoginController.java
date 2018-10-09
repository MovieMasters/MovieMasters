package controller;

import datastorage.MovieDAO;
import domain.MovieCollection;
import view.*;

import java.awt.event.ActionEvent;

public class LoginController extends Controller {
    private LoginView loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Register":
                break;
            case "LoginView":
                View view = MainFrame.getMainFrame().getViewMap().get(ViewName.MOVIECOLLECTION);

                if (view == null){
                    MovieDAO movieDAO = new MovieDAO();
                    MovieCollection mcCollection = movieDAO.getActualMovies();
                    view = new MovieCollectionView(mcCollection);
                }
                MainFrame.getMainFrame().setView(view);
                break;
        }
    }
}
