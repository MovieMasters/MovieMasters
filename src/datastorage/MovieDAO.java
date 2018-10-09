package datastorage;

import domain.Movie;
import domain.MovieCollection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MovieDAO extends DAO{
    public MovieDAO() {
        // Nothing to be initialized. This is a stateless class. Constructor
        // has been added to explicitely make this clear.
    }

    public MovieCollection getActualMovies(){
        MovieCollection movieCollection = new MovieCollection();
        ResultSet rs = executeQuery(
            "SELECT\n" +
                    "       movie.id,\n" +
                    "       movie.title,\n" +
                    "       movie.releaseDate,\n" +
                    "       movie.playTime,\n" +
                    "       movie.summary,\n" +
                    "       language.language,\n" +
                    "       `show`.date,\n" +
                    "       `show`.time\n" +
                    "FROM\n" +
                    "      movie\n" +
                    "         LEFT JOIN `show`\n" +
                    "         ON movie.id = `show`.movieId\n" +
                    "         LEFT JOIN language\n" +
                    "         ON language.code = movie.languageCode\n" +
                    //ToDo alter query so only movie with future shows will be added
                    "WHERE `show`.Date > '2017-12-01';"
        );

        if (rs != null){
            try{
                while(rs.next()){
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    Date releaseDate = rs.getDate("releaseDate");
                    int playTime = rs.getInt("playTime");
                    String summary = rs.getString("summary");
                    String language = rs.getString("language");

                    Movie movie = new Movie(
                        id,
                        title,
                        releaseDate,
                        playTime,
                        summary,
                        language
                    );
                    movieCollection.addMovie(movie);
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return movieCollection;
    }

    public Movie getMovie(int movieId){
        ResultSet rs = executeQuery(
                "SELECT movie.id, movie.title, movie.releaseDate, movie.playTime, movie.summary, language.language FROM movie INNER JOIN language ON language.code = movie.languageCode WHERE movie.id = " + movieId + ";"
        );
        Movie movie = null;
        if (rs != null){
            try{
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    Date releaseDate = rs.getDate("releaseDate");
                    int playTime = rs.getInt("playTime");
                    String summary = rs.getString("summary");
                    String language = rs.getString("language");

                    movie = new Movie(
                        id,
                        title,
                        releaseDate,
                        playTime,
                        summary,
                        language
                    );
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return movie;
    }
}
