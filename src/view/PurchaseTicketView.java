package view;

import controller.TicketController;
import domain.Movie;
import domain.PriceCategory;
import domain.Show;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.lang.reflect.Array;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeSet;

public class PurchaseTicketView extends View {
    private Movie movie;
    private ArrayList<PriceCategory> priceCategories;
    private TicketController controller;
    private ArrayList<Show> currentShows;
    private JComboBox boxTheater, boxDate, boxTime;

    public PurchaseTicketView(Movie movieModel, ArrayList<PriceCategory> priceCategories){
        super();
        this.viewName = ViewName.TICKET;
        this.priceCategories = priceCategories;
        this.movie = movieModel;
        this.controller = new TicketController(movieModel, priceCategories, this);
        createGUI();
    }

    private void createGUI() {
        // Create GridBagConstraints
        setLayout(new GridBagLayout());
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

        //Add Separator to Mainpanel
        c.gridy++;
        JSeparator jsp = new JSeparator();
        jsp.setOrientation(JSeparator.HORIZONTAL);
        add(jsp, c);

        // Add bottom panel to Mainpanel
        c.gridy++;
        JPanel pnlBottom = new JPanel();
        prepareBottomPanel(pnlBottom);
        add(pnlBottom, c);

    }

    //Function to setup content of Top panel
    private void prepareTopPanel(JPanel panel){
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        Border border = BorderFactory.createLineBorder(Color.RED);
//        panel.setBorder(border);
        c.insets = new Insets(2,2,2,2);
        c.weightx = 1.0;
        c.weighty = 1.0;

        //Set image
        c.fill = GridBagConstraints.VERTICAL;
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 6;
        ImageIcon icon = setImageforLabel("src/resources/big/movie_" + movie.getId() + ".jpg", 175, 260);
        JLabel lblImage = new JLabel(icon);
        lblImage.setHorizontalAlignment(JLabel.LEFT);
        lblImage.setVerticalAlignment(JLabel.NORTH);
        lblImage.setBorder(border);
        panel.add(lblImage, c);

        //Set Title
        c.weightx = 1;
        c.weighty = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 2;
        c.ipadx = 0;
        c.ipady = 0;
        JLabel lblTitle = new JLabel(movie.getTitle());
        float fontSize = 30f;
        lblTitle.setFont(lblTitle.getFont().deriveFont(fontSize));
        c.insets = new Insets(0,0,30,0);
        panel.add(lblTitle, c);

        //Set Date Time and Location Labelfields
        c.insets = new Insets(10,10,10,10);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 0;
        c.weighty = 0;
        c.ipady = 0;
        c.ipadx = 20;
        JLabel lblLocation = new JLabel("Locatie: ");
        panel.add(lblLocation, c);

        c.gridx = 1;
        c.gridy = 2;
        JLabel lblDate = new JLabel("Datum: ");
        panel.add(lblDate, c);

        c.gridx = 1;
        c.gridy = 3;
        JLabel lblTime = new JLabel("Aanvangstijd: ");
        panel.add(lblTime, c);

        c.gridx = 2;
        c.gridy = 1;
        boxTheater = new JComboBox();
        panel.add(boxTheater, c);
        boxTheater.addItemListener(controller);

        c.gridy = 2;
        boxDate = new JComboBox();
        panel.add(boxDate, c);
        boxDate.addItemListener(controller);

        c.gridy = 3;
        boxTime = new JComboBox();
        panel.add(boxTime, c);

        fillBoxTheaters();
        fillBoxDates();
    }

    //Function to setup content of Bottom panel
    private void prepareBottomPanel(JPanel panel){
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        Border border = BorderFactory.createLineBorder(Color.MAGENTA);
        Border emptyBorder = BorderFactory.createEmptyBorder(0,5,0,5);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(2,2,2,2);
        c.weightx = 1.0;
        c.weighty = 1.0;

        //Set header
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        JLabel lblHeader = new JLabel("Selecteer de gewenste tickets", JLabel.CENTER);
        float fontSize = 20f;
        lblHeader.setFont(lblHeader.getFont().deriveFont(fontSize));
        panel.add(lblHeader, c);

        c.gridwidth = 1;
        c.gridy = 1;
        c.insets = new Insets(2,0,2,0);
        int rowCount = 0;
        for (PriceCategory p : priceCategories) {
            c.gridx = 0;
            c.ipadx = 480;
            JLabel lblPrice = new JLabel(p.getName() + ": \u20ac " + p.getPrice());
            lblPrice.setBorder(emptyBorder);
            if(rowCount % 2 == 0){
                lblPrice.setOpaque(true);
                lblPrice.setBackground(Color.decode("#d6d6d6"));
            }
            panel.add(lblPrice, c);

            c.gridx = 1;
            c.ipadx = 30;
            JLabel lblAmount = new JLabel("Aantal: ");
            if(rowCount % 2 == 0){
                lblAmount.setOpaque(true);
                lblAmount.setBackground(Color.decode("#d6d6d6"));
            }
            panel.add(lblAmount, c);

            c.gridx = 2;
            c.ipadx = 0;
            String[] amountOptions = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
            JComboBox<String> cbxAmount = new JComboBox<>(amountOptions);
            cbxAmount.addActionListener(controller);
            cbxAmount.setActionCommand(p.getName());
            cbxAmount.setBorder(emptyBorder);
            panel.add(cbxAmount, c);

            rowCount++;
            c.gridy++;
        }

        c.insets = new Insets(2,2,2,2);

        c.gridx = 1;
        c.gridy++;
        c.gridwidth = 2;
        JButton btnBuy = new JButton("Tickets aanschaffen");
        btnBuy.addActionListener(controller);
        btnBuy.setActionCommand("Purchase");
        panel.add(btnBuy, c);
    }

    private void fillBoxTheaters(){
        HashMap<String, ArrayList<Show>> mapShows = movie.getShows();
        if(mapShows != null) {
            TreeSet<String> theaters = new TreeSet<>();
            mapShows.forEach((theater, showList) -> {
                theaters.add(theater);
            });
            boxTheater.setModel(new DefaultComboBoxModel(theaters.toArray()));
        }
    }

    public void fillBoxDates(){
        currentShows = movie.getShows().get(boxTheater.getSelectedItem().toString());
        if(currentShows != null) {
            TreeSet<LocalDate> dates = new TreeSet<>();
            currentShows.forEach(show -> {
               dates.add(show.getDate());
            });
            boxDate.setModel(new DefaultComboBoxModel(dates.toArray()));
        }
        fillBoxTimes();
    }

    public void fillBoxTimes(){
        if(currentShows != null) {
            TreeSet<LocalTime> times = new TreeSet<>();
            currentShows.forEach(show -> {
                if(show.getDate().equals(boxDate.getSelectedItem())) {
                    times.add(show.getTime());
                }
            });
            boxTime.setModel(new DefaultComboBoxModel(times.toArray()));
        }
    }

    public JComboBox getBoxTheater() {
        return boxTheater;
    }

    public JComboBox getBoxDate() {
        return boxDate;
    }

    public JComboBox getBoxTime() {
        return boxTime;
    }

}
