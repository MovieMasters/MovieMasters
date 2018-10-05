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

            JPanel movieItem = new JPanel();
            JLabel image = new JLabel(icon, JLabel.CENTER);
            JLabel title = new JLabel(movie.getTitle());
            GridBagConstraints gbc;

            // Set Layout manager
            movieItem.setLayout(new GridBagLayout());

            // Set image size for each movie
//            image.setPreferredSize(new Dimension(146, 207));

            // Create border for clean development
            Border border2 = BorderFactory.createLineBorder(Color.RED, 1);
            movieItem.setBorder(border2);

            // Determine constraints for label image
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            //Add label to panel movieItem
            movieItem.add(image, gbc);

            // Determine contstraints for label title
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(3,3,3,3);
            //Add label to panel movieItem
            movieItem.add(title, gbc);

            // Add created panel movieItem to view MovieCollection
            add(movieItem);
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
