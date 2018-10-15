package controller;

import datastorage.TicketDAO;
import domain.*;
import view.MainFrame;
import view.PurchaseTicketView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TicketController extends Controller {
    private Ticket ticketModel;
    private Movie movieModel;
    private Show showModel;
    private PriceCategory priceModel;
    private PurchaseTicketView view;
    private ActionListener actionListener;

    public TicketController(Movie movie, PurchaseTicketView ticketView){
        super();
        this.view = view;
        this.movieModel = movie;
    }

    public Show getShowModel() {
        return showModel;
    }

    public ArrayList<PriceCategory> getPriceCategories() {
        TicketDAO ticketDAO = new TicketDAO();
        return ticketDAO.getTicketTypes();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
