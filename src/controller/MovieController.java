package controller;

import view.MovieCollection;
import java.awt.event.ActionEvent;

public class MovieController extends Controller {
    private MovieCollection movieCollection;

    public MovieController(MovieCollection movieCollection) {
        this.movieCollection = movieCollection;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
