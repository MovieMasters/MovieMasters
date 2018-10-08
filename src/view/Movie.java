package view;

import controller.MovieController;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Movie extends View {
    private JLabel lblHeader;
    private JPanel pnlContent;
    private JLabel lblImage;
    private JLabel lblTitleLabel;
    private JLabel lblTitle;
    private JLabel lblReleaseDateLabel;
    private JLabel lblReleaseDate;
    private JLabel lblPlayTimeLabel;
    private JLabel lblPlayTime;
    private JLabel lblLanguageLabel;
    private JLabel lblLanguage;
    private JLabel lblProducerLabel;
    private JLabel lblProducer;
    private JLabel lblActorsLabel;
    private JLabel lblActors;
    private JLabel lblSummary;

    private MovieController movieController;
    private domain.Movie movie;

    public Movie(domain.Movie movie){
        this.movieController = new MovieController(this);
        this.movie = movie;
        setLayout(new GridBagLayout());
        JPanel panel = new JPanel();
        JLabel image = new JLabel(createImageIcon("/images/big/movie_" + movie.getId() + ".jpg", movie.getTitle()));
        panel.add(image);
        add(panel);
    }

    // Function to return Icon object. Returns null if path is not found.
    private ImageIcon createImageIcon(String path, String description){
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null){
            return resizeImage(new ImageIcon(imgURL, description));
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    private ImageIcon resizeImage(ImageIcon icon){
        Image img = icon.getImage();
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        Graphics g = bi.createGraphics();
        g.drawImage(img, 0, 0, 201, 285, null);

        ImageIcon resizedIcon = new ImageIcon(bi);

        return resizedIcon;
    }

}
