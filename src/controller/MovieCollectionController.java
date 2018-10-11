package controller;

import datastorage.MovieDAO;
import domain.Movie;
import domain.MovieCollection;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieCollectionController extends Controller {
    private MovieCollection model;
    private MovieCollectionView view;
    private ActionListener actionListener;

    public MovieCollectionController (MovieCollection model, MovieCollectionView view){
        super();
        this.model = model;
        this.view = view;
    }



    private MovieCollection getActualMovies(){
        MovieDAO mcDAO = new MovieDAO();
        return mcDAO.getActualMovies();
    }

//    private void createMovieItems(MovieCollection model){
//        view.createMovieItems(model.getCollection());
//    }

    public void showView(){
    }

//    public void btnListeners(){
//        actionListener = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int i = Integer.parseInt(e.getActionCommand());
//                MainFrame.getMainFrame().setView(ViewName.MOVIE());
//            }
//        };
//        for (Movie movie : model.getCollection().values()){
//            int movieId = movie.getId();
//            view.getButton("movie_"+movieId).addActionListener(actionListener);
//        }
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int movieId = Integer.parseInt(e.getActionCommand());
        System.out.println(movieId);

        MovieDAO movieDAO = new MovieDAO();
        Movie movie = movieDAO.getMovie(movieId);
        View view = new MovieView(movie);

        MainFrame.getMainFrame().setView(view);
    }

}
