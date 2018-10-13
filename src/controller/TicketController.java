package controller;

import domain.Ticket;
import view.PurchaseTicketView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketController extends Controller {
    private Ticket model;
    private PurchaseTicketView view;
    private ActionListener actionListener;

    public TicketController(PurchaseTicketView view){
        super();
        this.view = view;
    }
    public TicketController(Ticket model, PurchaseTicketView view){
        this(view);
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
