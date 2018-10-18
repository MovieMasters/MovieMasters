package controller;

import datastorage.TicketDAO;
import domain.*;
import view.MainFrame;
import view.PurchaseTicketView;

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
        //this.tickets = new HashMap<>();
    }

//    public HashMap<String, HashMap<Integer, Ticket>> getTickets() {
//        return tickets;
//    }
//
//    private void addTicket(String priceName, Ticket ticket){
//        if (!tickets.containsKey(priceName)) {
//            HashMap<Integer, Ticket> hm2 = new HashMap<>();
//            hm2.put(1, ticket);
//            tickets.put(priceName, hm2);
//        } else {
//            int key = tickets.get(priceName).size()+1;
//            tickets.get(priceName).put(key, ticket);
//        }
//    }
//
//    private void printTickets(){
//        System.out.println("---- Tickets stored ---");
//        System.out.println(tickets);
//        System.out.println("-----------------------\n");
//    }
//
//    private PriceCategory getPriceCategory(String categoryName){
//        PriceCategory priceCategory = null;
//        for (PriceCategory p : priceCategories){
//            if (p.getName().equalsIgnoreCase(categoryName)){
//                priceCategory = p;
//            }
//        }
//        return priceCategory;
//    }

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
            case "Location":
                //Code
                break;
            case "Date":
                //Code
                break;
            case "Purchase":

//                TicketDAO ticketDAO = new TicketDAO();
//                ticketDAO.createTickets(tickets);
//                JOptionPane.showMessageDialog(MainFrame.getMainFrame().getContentPane(), "Uw bestelling is verwerkt. Uw tickets zullen naar het door u opgegeven e-mailadres verzonden worden. Fijne voorstelling!");
//                System.exit(-1);
                break;
//            default:
//                JComboBox<String> combo = (JComboBox<String>) e.getSource();
//                String selectedItem = (String) combo.getSelectedItem();
//                int amount = Integer.parseInt(selectedItem);
//                String priceName = e.getActionCommand().substring(7);
//                String switchValue = e.getActionCommand().substring(0,6);
//                PriceCategory pc = getPriceCategory(priceName);
                //ToDo HARDCODED!!!
//                Show show = movieModel.getShows().get(0);
//                Account account = MainFrame.getMainFrame().getCachedUser();
//
//
//                if (amount <= 0) {
//                    if (tickets.get(priceName) != null) {
//                        tickets.remove(priceName);
//                    }
//                } else {
//                    for (int i = 0; i < amount; i++) {
//                        Ticket ticket = new Ticket(show, account, pc);
//                        addTicket(priceName, ticket);
//                    }
//                }
//                printTickets();
//                break;
        }
    }
}
