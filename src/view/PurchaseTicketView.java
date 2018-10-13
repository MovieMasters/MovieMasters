package view;

import controller.TicketController;
import datastorage.TicketDAO;
import domain.Movie;
import domain.PriceCategory;
import domain.Ticket;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class PurchaseTicketView extends View {
    private ArrayList<Ticket> tickets;
    private ArrayList<PriceCategory> priceCategoryList;
    private TicketController controller;
    private Movie movie;

    public PurchaseTicketView(Movie movie){
        super();
        this.viewName = ViewName.TICKET;
        this.priceCategoryList = getPriceCategories();
        this.controller = new TicketController(this);
        this.movie = movie;
        createGUI();
    }

    private ArrayList<PriceCategory> getPriceCategories() {
        TicketDAO ticketDAO = new TicketDAO();
        return ticketDAO.getTicketTypes();
    }


    private void createGUI() {
        // Create GridBagConstraints
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLUE));
        GridBagConstraints c = new GridBagConstraints();

        // Add top panel to Mainpanel
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        JPanel pnlTop = new JPanel();
        prepareTopPanel(pnlTop);
        add(pnlTop, c);

        // Add bottom panel to Mainpanel
        c.gridy++;
        JPanel pnlBottom = new JPanel();
        prepareBottomPanel(pnlBottom);
        add(pnlBottom, c);

    }

    private void prepareTopPanel(JPanel panel){
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        Border border = BorderFactory.createLineBorder(Color.RED);
        panel.setBorder(border);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(2,2,2,2);
        c.weightx = 1.0;
        c.weighty = 1.0;

        //Set image
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 6;
        ImageIcon icon = setImageforLabel("src/resources/big/movie_" + movie.getId() + ".jpg", 175, 260);
        JLabel lblImage = new JLabel(icon);
        lblImage.setHorizontalAlignment(JLabel.LEFT);
        lblImage.setVerticalAlignment(JLabel.NORTH);
//        lblImage.setBorder(border);
        panel.add(lblImage, c);

        //Set Title
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.ipadx = 0;
        c.ipady = 0;
        JLabel lblTitle = new JLabel(movie.getTitle());
        float fontSize = 30f;
//        lblTitle.setBorder(border);
        lblTitle.setFont(lblTitle.getFont().deriveFont(fontSize));
        panel.add(lblTitle, c);

        //Set Date Time and Location Labelfields
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0;
        c.weightx = 0;
        c.ipady = 0;
        c.ipadx = 50;
        JLabel lblDate = new JLabel("Datum: ",JLabel.RIGHT);
//        lblDate.setBorder(border);
        panel.add(lblDate, c);

        c.gridx = 1;
        c.gridy = 2;
        JLabel lblTime = new JLabel("Aanvangstijd: ", JLabel.RIGHT);
        lblTime.setBorder(border);
        panel.add(lblTime, c);

        c.gridx = 1;
        c.gridy = 3;
        JLabel lblLocation = new JLabel("Locatie: ", JLabel.RIGHT);
//        lblLocation.setBorder(border);
        panel.add(lblLocation, c);

        //Set Date Tim and Location Valuefields
        c.gridx = 2;
        c.gridy = 1;
        JLabel lblDateValue = new JLabel("11-10-2018");
//        lblDateValue.setBorder(border);
        panel.add(lblDateValue, c);

        c.gridy = 2;
        JLabel lblTimeValue = new JLabel("19:45");
//        lblTimeValue.setBorder(border);
        panel.add(lblTimeValue, c);

        c.gridy = 3;
        JLabel lblLocationValue = new JLabel("Kinepolis Dordrecht");
//        lblLocationValue.setBorder(border);
        panel.add(lblLocationValue, c);

//        c.gridwidth = 2;
//        c.gridx = 2;
//        c.gridy = 4;
//        panel.add(new JLabel(" "), c);
//        c.gridy++;
//        panel.add(new JLabel(" "), c);
    }

    private void prepareBottomPanel(JPanel panel){
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        Border border = BorderFactory.createLineBorder(Color.MAGENTA);
        panel.setBorder(border);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(2,2,2,2);
        c.weightx = 1.0;
        c.weighty = 1.0;

        //Set header
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        JLabel lblHeader = new JLabel("Selecteer de gewenste tickets", JLabel.CENTER);
        lblHeader.setBorder(border);
        panel.add(lblHeader, c);

        c.gridwidth = 1;
        c.gridy = 1;
        //Todo Hardcoded, needs change to DAO

        //Todo START FOREACH
        for (PriceCategory p : priceCategoryList) {
            c.gridx = 0;
            c.ipadx = 400;
            JLabel lblPrice = new JLabel(p.getName() + ": \u20ac " + p.getPrice());
            lblPrice.setBorder(border);
            panel.add(lblPrice, c);

            c.gridx = 1;
            c.ipadx = 50;
            JLabel lblAmount = new JLabel("Aantal: ");
            lblAmount.setBorder(border);
            panel.add(lblAmount, c);

            c.gridx = 2;
            c.ipadx = 0;
            String[] amountOptions = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
            JComboBox<String> cbxAmount = new JComboBox<>(amountOptions);
            panel.add(cbxAmount, c);

            c.gridy++;
        }
        // Todo END FOREACH

        c.gridx = 1;
        c.gridy++;
        c.gridwidth = 2;
        JButton btnBuy = new JButton("Tickets aanschaffen");
        panel.add(btnBuy, c);
    }
}
