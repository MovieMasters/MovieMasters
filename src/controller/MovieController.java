package controller;

import domain.Movie;
import view.MovieView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieController extends Controller {
    private Movie model;
    private MovieView view;
    private ActionListener actionListener;

    public MovieController(Movie model, MovieView view){
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
