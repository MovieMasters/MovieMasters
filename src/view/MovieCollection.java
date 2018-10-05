package view;

import controller.MovieController;
import domain.Movie;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MovieCollection extends View{

    private MovieController movieController;
    private Map<String, Movie> collection;

    public MovieCollection(){
        movieController = new MovieController(this);
        collection = movieController.getActualMovies().getCollection();
        createMovieItems(collection);
    }

    /***
     * Iterate through collection, and add a JPanel for each Movie to this view
     */
    private void createMovieItems(Map<String, Movie> collection){
        for (Movie movie : collection.values()){
            // ToDo Create Labels for 1 movie
            Icon icon = createImageIcon("/images/movie_" + movie.getId() + ".jpg", movie.getTitle());

            JPanel pnlMovieItem = new JPanel();

            JButton btnImage = new JButton();
            btnImage.setIcon(icon);
            btnImage.setActionCommand(Integer.toString(movie.getId()));
            btnImage.addActionListener(movieController);

            JLabel lblTitle = new JLabel(movie.getTitle());

            GridBagConstraints gbc;

            // Set Layout manager
            pnlMovieItem.setLayout(new GridBagLayout());

            // Determine constraints for label lblImage
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            //Add label to panel pnlMovieItem
            pnlMovieItem.add(btnImage, gbc);

            // Determine contstraints for label title
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(3,3,3,3);
            //Add label to panel pnlMovieItem
            pnlMovieItem.add(lblTitle, gbc);

            // Add created panel pnlMovieItem to view MovieCollection
            add(pnlMovieItem);
        }
    }

    // Function to return Icon object. Returns null if path is not found.
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
