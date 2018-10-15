package view;

import controller.MovieCollectionController;
import domain.Movie;
import domain.MovieCollection;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MovieCollectionView extends View {
    Map<String, JButton> buttons;
    MovieCollection movieCollection;
    MovieCollectionController movieCollectionController;

    public MovieCollectionView(MovieCollection movieCollection){
        this.viewName = ViewName.MOVIECOLLECTION;
        buttons = new HashMap<String, JButton>();
        this.movieCollection = movieCollection;
        movieCollectionController = new MovieCollectionController(movieCollection, this);
        createMovieItems();
    }

    public void createMovieItems(){
        for (Movie movie : movieCollection.getCollection().values()){

            ImageIcon icon = setImageforLabel("src/resources/movie_" + movie.getId() + ".jpg", 146, 207);

            JPanel pnlMovieItem = new JPanel();

            JButton btnImage = new JButton();
            btnImage.setIcon(icon);
            btnImage.setActionCommand(Integer.toString(movie.getId()));
            btnImage.addActionListener(movieCollectionController);
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

    private void addButtonToButtons(int i, JButton imageButton){
        buttons.put("movie_"+i, imageButton);
    }

    public JButton getButton(String i){
        return buttons.get(i);
    }
}
