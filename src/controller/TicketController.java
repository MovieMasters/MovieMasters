package controller;

import datastorage.TicketDAO;
import domain.Account;
import domain.PriceCategory;
import domain.Show;
import domain.Ticket;
import view.MainFrame;
import view.PurchaseTicketView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TicketController extends Controller {
    private Ticket ticketModel;
    private Show showModel;
    private Account accountModel;
    private PriceCategory priceModel;
    private PurchaseTicketView view;
    private ActionListener actionListener;

    public TicketController(PurchaseTicketView view){
        super();
        this.view = view;
        this.showModel = (Show) MainFrame.getMainFrame().getModelMap().get("show");
    }
    public TicketController(Ticket ticketModel, PurchaseTicketView view){
        this(view);
        this.ticketModel = ticketModel;
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
