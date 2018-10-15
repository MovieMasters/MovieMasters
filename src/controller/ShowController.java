package controller;

import datastorage.TicketDAO;
import domain.Movie;
import domain.Show;
import view.MainFrame;
import view.PurchaseTicketView;
import view.ShowView;
import view.View;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class ShowController extends Controller{
    private HashMap<Integer, Show> shows;
    private ShowView showView;
    private Movie movie;

    public ShowController(ShowView showView){
        super();
        this.showView = showView;
        this.movie = (Movie) MainFrame.getMainFrame().getModelMap().get("movie");
        this.shows = getShows(this.movie.getId());
    }

    public HashMap<Integer, Show> getShows(int movieId){
        TicketDAO showDAO = new TicketDAO();
        return showDAO.getShowsForMovie(movieId);
    }

    public Movie getMovie() {
        return movie;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int showId = Integer.parseInt(e.getActionCommand());
        this.shows = getShows(movie.getId());
        Show show = null;
        for (Show s : shows.values()){
            if (s.getId() == showId){
                show = s;
            }
        }
        MainFrame.getMainFrame().addModel("show", show);
        PurchaseTicketView ticketView  = new PurchaseTicketView();
        MainFrame.getMainFrame().setView(ticketView);
    }
}
