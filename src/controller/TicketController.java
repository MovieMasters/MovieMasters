package controller;

import datastorage.MovieDAO;
import datastorage.TicketDAO;
import domain.*;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;

public class TicketController extends Controller implements ItemListener {
    private Movie movie;
    private ArrayList<PriceCategory> priceCategories;
    private PurchaseTicketView ticketView;
    private HashMap<PriceCategory, Integer> tickets;
    //private HashMap<String, HashMap<Integer, Ticket>> tickets;

    public TicketController(Movie movie, ArrayList<PriceCategory> priceCategories, PurchaseTicketView ticketView){
        super();
        this.ticketView = ticketView;
        this.movie = movie;
        this.priceCategories = priceCategories;
        this.tickets = new HashMap<>();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            if (e.getSource() == ticketView.getBoxTheater()) {
                ticketView.fillBoxDates();
            }
            if (e.getSource() == ticketView.getBoxDate()) {
                ticketView.fillBoxTimes();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Back":
                View view = MainFrame.getMainFrame().getViewMap().get(ViewName.MOVIECOLLECTION);

                if (view == null){
                    MovieDAO movieDAO = new MovieDAO();
                    MovieCollection mcCollection = movieDAO.getActualMovies();
                    view = new MovieCollectionView(mcCollection);
                }
                MainFrame.getMainFrame().setView(view);
                break;
            case "Purchase":
                    Show selectedShow = null;
                    ArrayList<Show> shows = movie.getShows().get(ticketView.getBoxTheater().getSelectedItem().toString());
                for (Show show : shows) {
                    if (show.getDate().equals(ticketView.getBoxDate().getSelectedItem())
                            && show.getTime().equals(ticketView.getBoxTime().getSelectedItem())) {
                        selectedShow = show;
                    }
                }
                    TicketDAO ticketDAO = new TicketDAO();
                    ticketDAO.createTickets(tickets, selectedShow);
//                JOptionPane.showMessageDialog(MainFrame.getMainFrame().getContentPane(), "Uw bestelling is verwerkt. Uw tickets zullen naar het door u opgegeven e-mailadres verzonden worden. Fijne voorstelling!");
//                System.exit(-1);
                break;
            default:
                for(PriceCategory p : priceCategories){
                    if(p.getName().equals(e.getActionCommand())){
                        JComboBox<String> combo = (JComboBox<String>) e.getSource();
                        int amount = Integer.parseInt( combo.getSelectedItem().toString());
                        tickets.put(p,amount);
                    }
                }
                break;
        }
    }
}
