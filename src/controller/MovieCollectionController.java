package controller;

import datastorage.MovieDAO;
import domain.Movie;
import domain.MovieCollection;
import view.*;

import java.awt.event.ActionEvent;

public class MovieCollectionController extends Controller {
    private MovieCollection movieCollection;
    private MovieCollectionView movieCollectionView;

    public MovieCollectionController (MovieCollection movieCollection, MovieCollectionView movieCollectionView){
        super();
        this.movieCollection = movieCollection;
        this.movieCollectionView = movieCollectionView;
    }

    /**
     * Executed on action event when user clicks on any movie in the collection
     *
     * @param e the ActionEvent created when user click on the component
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int movieId = Integer.parseInt(e.getActionCommand());
        MovieDAO movieDAO = new MovieDAO();
        Movie movie = movieDAO.find(movieId);
        View view = new MovieView(movie);
        MainFrame.getMainFrame().setTitle("MovieMasters - Filmdetails: " + movie.getTitle());
        MainFrame.getMainFrame().setView(view);
    }

}
