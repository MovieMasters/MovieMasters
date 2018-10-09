package domain;

import java.util.HashMap;
import java.util.Map;

public class MovieCollection {

    private Map<String, Movie> collection;

    public MovieCollection(){
        this.collection = new HashMap<>();
    }

    public Map<String, Movie> getCollection(){
        return collection;
    }

    public void addMovie(Movie movie){
        String movieTitle = movie.getTitle();
        collection.put(movieTitle, movie);
    }

    public void setMovieCollection(Map<String, Movie> movieCollection) {
        this.collection = movieCollection;
    }
}
