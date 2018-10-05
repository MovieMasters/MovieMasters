package controller;

import datastorage.MovieCollectionDAO;
import view.MovieCollection;
import java.awt.event.ActionEvent;

public class MovieController extends Controller {
    private view.MovieCollection movieCollectionView;

    public MovieController(view.MovieCollection movieCollection) {
        this.movieCollectionView = movieCollection;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public domain.MovieCollection getActualMovies(){
        MovieCollectionDAO mcDAO = new MovieCollectionDAO();
        return mcDAO.getActualMovies();
    }
}
