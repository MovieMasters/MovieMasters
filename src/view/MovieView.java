package view;

import controller.MovieController;
import domain.CastMember;
import domain.Movie;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class MovieView extends View {
    private Movie movie;
    private MovieController movieController;

    public MovieView(Movie movie){
        this.viewName = ViewName.MOVIE;
        this.movie = movie;
        this.movieController = new MovieController(this.movie,this);

        setLayout(new GridBagLayout());
        createView();
    }

    private void createView(){
        JPanel pnlTopLeft = new JPanel();
        JPanel pnlTopRight = new JPanel();
        JPanel pnlBottom = new JPanel();

        pnlTopLeft.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnlTopRight.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnlBottom.setBorder(BorderFactory.createLineBorder(Color.RED));

        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(2,2,2,2);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(pnlTopLeft, gbc);

        gbc.gridx = 1;
        gbc.weightx = 2.0;
        add(pnlTopRight, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.weightx = 0.0;
        gbc.gridwidth = 3;
        add(pnlBottom, gbc);


        // Adding content to Top Left Panel
        pnlTopLeft.setLayout(new FlowLayout());
        Icon icon = createImageIcon("/resources/big/movie_" + movie.getId() + ".jpg", movie.getTitle());
        JLabel lblImage = new JLabel();
        lblImage.setIcon(icon);
        pnlTopLeft.add(lblImage);

        // Adding content to Top Right panel
        pnlTopRight.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;

        JLabel lblTitle = new JLabel(movie.getTitle(), JLabel.CENTER );
        lblTitle.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnlTopRight.add(lblTitle, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel lblDate = new JLabel("Releasedatum:");
        lblDate.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnlTopRight.add(lblDate, gbc);

        gbc.gridx = 1;
        JLabel lblDateValue = new JLabel();
        lblDateValue.setText(convertDateToString(movie.getReleaseDate()));
        lblDateValue.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnlTopRight.add(lblDateValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel lblPlayTime = new JLabel("Speeltijd:");
        lblPlayTime.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnlTopRight.add(lblPlayTime, gbc);

        gbc.gridx = 1;
        JLabel lblPlayTimeValue = new JLabel(movie.getPlayTime() + " minuten");
        lblPlayTimeValue.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnlTopRight.add(lblPlayTimeValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel lblLanguage = new JLabel("Taal:");
        lblLanguage.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnlTopRight.add(lblLanguage, gbc);

        gbc.gridx = 1;
        JLabel lblLanguageValue = new JLabel("Nederlands (HARDCODED!)");
        lblLanguageValue.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnlTopRight.add(lblLanguageValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel lblDirector = new JLabel("Producer:");
        lblDirector.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnlTopRight.add(lblDirector, gbc);

        gbc.gridx = 1;
        JLabel lblDirectorValue = new JLabel("PietjePuk (HARDCODED!");
        lblDirectorValue.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnlTopRight.add(lblDirectorValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        JLabel lblActor = new JLabel("Acteurs:");
        lblActor.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnlTopRight.add(lblActor, gbc);

        gbc.gridy -= 1;
        for (CastMember member : movie.getCast().values()){
            if (member.getRole().equalsIgnoreCase("Acteur")){
                gbc.gridx = 1;
                gbc.gridy++;
                JLabel lblActorValue = new JLabel(member.getName());
                lblActorValue.setBorder(BorderFactory.createLineBorder(Color.RED));
                pnlTopRight.add(lblActorValue, gbc);
            }
        }


        // Adding content to bottom panel
        pnlBottom.setLayout(new GridBagLayout());
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;

        JLabel lblSummary = new JLabel("Omschrijving: ");
        lblSummary.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnlBottom.add(lblSummary, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel lblSummaryValue = new JLabel("<html>"+movie.getSummary()+"</html>");
        lblSummaryValue.setBorder(BorderFactory.createLineBorder(Color.RED));
        pnlBottom.add(lblSummaryValue, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        JButton btnBack = new JButton("Terug");
        btnBack.setActionCommand("Back");
        btnBack.addActionListener(movieController);
        pnlBottom.add(btnBack, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        JButton btnTicket = new JButton("Koop ticket");
        btnTicket.setActionCommand("Ticket");
        btnTicket.addActionListener(movieController);
        pnlBottom.add(btnTicket, gbc);
    }

    private ImageIcon createImageIcon(String path, String description){
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null){
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
