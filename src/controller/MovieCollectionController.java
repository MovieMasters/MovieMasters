package controller;

import datastorage.MovieDAO;
import domain.Movie;
import domain.MovieCollection;
import view.MovieCollectionView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieCollectionController {
    private MovieCollection model;
    private MovieCollectionView view;
    private ActionListener actionListener;

    public MovieCollectionController(MovieCollectionView view){
        this.model = getActualMovies();
        this.view = view;
        createMovieItems(model);
    }

    private MovieCollection getActualMovies(){
        MovieDAO mcDAO = new MovieDAO();
        return mcDAO.getActualMovies();
    }

    private void createMovieItems(MovieCollection model){
        view.createMovieItems(model.getCollection());
    }


    public void btnListeners(){
        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = Integer.parseInt(e.getActionCommand());

            }
        };
        for (Movie movie : model.getCollection().values()){
            int movieId = movie.getId();
            view.getButton("movie_"+movieId).addActionListener(actionListener);
        }
    }
}
