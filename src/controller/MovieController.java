package controller;

import domain.Movie;
import view.MovieView;
import java.awt.event.ActionListener;

public class MovieController {
    private Movie model;
    private MovieView view;
    private ActionListener actionListener;

    public MovieController(Movie model, MovieView view){
        this.model = model;
        this.view = view;
    }

    public void setTitle(){
        view.setTitle(model.getTitle());
    }
}
