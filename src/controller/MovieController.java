package controller;

import datastorage.MovieDAO;
import datastorage.TicketDAO;
import domain.*;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Map;

public class MovieController extends Controller {
    private Movie movie;
    private MovieView movieView;

    public MovieController(Movie movie, MovieView movieView){
        super();
        this.movie = movie;
        this.movieView = movieView;
    }
    public Map<String, CastMember> cast;

    /**
     * Executed on action event for components that are registered on the corresponding view
     *
     * @param e the ActionEvent created when user click on the component
     */
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

                MainFrame.getMainFrame().setTitle("MovieMasters - Film overzicht");
                MainFrame.getMainFrame().setView(view);
                break;
            case "Ticket":
                try {
                    TicketDAO ticketDAO = new TicketDAO();
                    ArrayList<PriceCategory> priceCategories = ticketDAO.getPriceCategories();
                    PurchaseTicketView ticketView = new PurchaseTicketView(movie, priceCategories);

                    MainFrame.getMainFrame().setTitle("MovieMasters - Tickets bestellen ("+movie.getTitle()+")");
                    MainFrame.getMainFrame().setView(ticketView);
                    break;
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(MainFrame.getMainFrame().getContentPane(), "Voor deze film zijn nog geen voorstellingen gepland!");
                    e1.printStackTrace();
                }
        }
    }
}
