package controller;

import datastorage.TicketDAO;
import domain.Show;
import view.ShowView;
import view.View;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ShowController extends Controller{
    private Show show;
    private ShowView showView;

    public ShowController(ShowView showView){
        super();
        this.showView = showView;
    }

    public ArrayList<Show> getShows(int movieId){
        TicketDAO showDAO = new TicketDAO();
        return showDAO.getShowsForMovie(movieId);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Show show;
    }
}
