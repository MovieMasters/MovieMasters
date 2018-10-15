package controller;

import datastorage.MovieDAO;
import domain.Movie;
import domain.MovieCollection;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieController extends Controller {
    private Movie model;
    private MovieView view;
    private ActionListener actionListener;

    public MovieController(Movie model, MovieView view){
        super();
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        View view;
        switch (e.getActionCommand()) {
            case "Back":
                view = MainFrame.getMainFrame().getViewMap().get(ViewName.MOVIECOLLECTION);

                if (view == null){
                    MovieDAO movieDAO = new MovieDAO();
                    MovieCollection mcCollection = movieDAO.getActualMovies();
                    view = new MovieCollectionView(mcCollection);
                }
                MainFrame.getMainFrame().setView(view);
                break;
            case "Ticket":
                ShowView showView = new ShowView();

                MainFrame.getMainFrame().setView(showView);

//                System.out.println("Clicked \"Buy Ticket\" button.");
//                PurchaseTicketView purchaseTicketView = new PurchaseTicketView();
//                MainFrame.getMainFrame().setView(purchaseTicketView);
                break;
        }
    }
}
