package controller;

import datastorage.TicketDAO;
import domain.*;
import view.MainFrame;
import view.PurchaseTicketView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TicketController extends Controller {
    private HashMap<String, HashMap<Integer, Ticket>> tickets;
    private Movie movieModel;
    private Show showModel;
    private PriceCategory priceModel;
    private PurchaseTicketView view;
    private ActionListener actionListener;

    public TicketController(Movie movie, PurchaseTicketView ticketView){
        super();
        this.view = view;
        this.movieModel = movie;
        this.tickets = new HashMap<>();
    }

    public HashMap<String, HashMap<Integer, Ticket>> getTickets() {
        return tickets;
    }

    public void addTicket(String priceName, Ticket ticket){
        if (!tickets.containsKey(priceName)) {
            HashMap<Integer, Ticket> hm2 = new HashMap<>();
            hm2.put(1, ticket);
            tickets.put(priceName, hm2);
        } else {
            int key = tickets.get(priceName).size()+1;
            tickets.get(priceName).put(key, ticket);
        }
    }

    public void printTickets(){
        System.out.println("---- Tickets stored ---");
        System.out.println(tickets);
        System.out.println("-----------------------\n");
    }

    public ArrayList<PriceCategory> getPriceCategories() {
        TicketDAO ticketDAO = new TicketDAO();
        return ticketDAO.getPriceCategories();
    }

    public PriceCategory getPriceCategory(String categoryName){
        PriceCategory priceCategory = null;
        for (PriceCategory p : getPriceCategories()){
            if (p.getName().equalsIgnoreCase(categoryName)){
                priceCategory = p;
            }
        }
        return priceCategory;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int amount = Integer.parseInt(e.getActionCommand());
        String priceName = e.getActionCommand().substring(7);

        //ToDo HARDCODED!!!
        PriceCategory pc = getPriceCategory("CJP-ticket");
        Show show = movieModel.getShows().get(1);
        //ToDo

        Account account = (Account) MainFrame.getMainFrame().getModelMap().get("account");

        switch (e.getActionCommand()){
            case "Location":
                //Code
                break;
            case "Date":
                //Code
                break;
            case "Purchase":
                TicketDAO ticketDAO = new TicketDAO();
                ticketDAO.createTickets(tickets);
                break;
            default:
                if (amount <= 0) {
                    if (tickets.get(priceName) != null) {
                        tickets.remove(priceName);
                    }
                } else {
                    for (int i = 0; i < amount; i++) {
                        Ticket ticket = new Ticket(show, account, pc);
                        addTicket(priceName, ticket);
                    }
                }
                printTickets();
                break;
        }

    }


}
