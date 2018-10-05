package view;

import controller.MovieController;

import javax.swing.*;
import java.awt.*;

public class Movie extends View {

    private MovieController movieController;
    private domain.Movie movie;

    public Movie(){
        movieController = new MovieController(this);
        setLayout(new GridBagLayout());
        JPanel panel = new JPanel();
        JLabel test = new JLabel("testlabel");
        panel.add(test);
        add(panel);
        this.movie = movie;
    }

}
