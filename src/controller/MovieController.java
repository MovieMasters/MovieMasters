package controller;

import datastorage.MovieDAO;
import view.MainFrame;
import view.ViewName;

import java.awt.event.ActionEvent;

public class MovieController extends Controller {
    private view.MovieCollection movieCollectionView;
    private view.Movie movieView;

    public MovieController(view.MovieCollection movieCollection) {
        this.movieCollectionView = movieCollection;
    }

    public MovieController (view.Movie movie){
        this.movieView = movie;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int movieId = Integer.parseInt(e.getActionCommand());
        domain.Movie movie = getMovie(movieId);
        MainFrame.getMainFrame().setView(ViewName.MOVIE, false, movie);
    }

    public domain.MovieCollection getActualMovies(){
        MovieDAO mcDAO = new MovieDAO();
        return mcDAO.getActualMovies();
    }

    private domain.Movie getMovie(int movieId){
        MovieDAO movieDAO = new MovieDAO();
        return movieDAO.getMovie(movieId);
    }
}
