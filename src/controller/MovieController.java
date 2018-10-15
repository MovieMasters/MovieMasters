package controller;

import datastorage.MovieDAO;
import datastorage.TicketDAO;
import domain.*;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MovieController extends Controller {
    private Movie movieModel;
    private MovieView movieView;
    private ActionListener actionListener;

    public MovieController(Movie movieModel, MovieView movieView){
        super();
        this.movieModel = movieModel;
        this.movieView = movieView;
    }

    public Map<String, CastMember> cast;

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
                TicketDAO ticketDAO = new TicketDAO();
                ArrayList<PriceCategory> priceCategories = ticketDAO.getTicketTypes();
                PurchaseTicketView ticketView = new PurchaseTicketView(movieModel, priceCategories);

                MainFrame.getMainFrame().setView(ticketView);
                break;
        }
    }
}
