package view;

import controller.MovieController;
import domain.Movie;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MovieCollection extends View{

    private MovieController movieController;

    public MovieCollection(){
        movieController = new MovieController(this);
        Map<String, Movie> test = new HashMap<>();
        test.put("Mission Impossible", new Movie(2, "Mission Impossible", new Date(), 112, "Omschrijving1", "Engels"));
        test.put("Despicable Me1", new Movie(3, "Despicable Me", new Date(), 122, "Omschrijving2", "Nederlands"));
        test.put("Despicable Me2", new Movie(4, "Despicable Me", new Date(), 122, "Omschrijving2", "Nederlands"));
        test.put("Despicable Me3", new Movie(5, "Despicable Me", new Date(), 122, "Omschrijving2", "Nederlands"));
        test.put("Despicable Me4", new Movie(6, "Despicable Me", new Date(), 122, "Omschrijving2", "Nederlands"));
        test.put("Despicable Me5", new Movie(7, "Despicable Me", new Date(), 122, "Omschrijving2", "Nederlands"));
        createMovieItem(test);
    }

    private void createMovieItem(Map<String, Movie> collection){
        int i = 1;
        for (Movie movie : collection.values()){
            // ToDo Create Labels for 1 movie
            JPanel movieItem = new JPanel();
            JLabel image = new JLabel();
            JLabel title = new JLabel(movie.getTitle());

            image.setPreferredSize(new Dimension(146, 207));

            Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
            Border border2 = BorderFactory.createLineBorder(Color.RED, 1);
            movieItem.setBorder(border2);
            image.setBorder(border);
            title.setBorder(border);

            movieItem.setLayout(new GridBagLayout());
            GridBagConstraints gbc;
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;

            movieItem.add(image, gbc);

            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            movieItem.add(title, gbc);

            add(movieItem);

            i++;
        }
    }
}
