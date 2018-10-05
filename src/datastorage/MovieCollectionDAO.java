package datastorage;

import domain.Movie;
import domain.MovieCollection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MovieCollectionDAO extends DAO{
    public MovieCollectionDAO() {
        // Nothing to be initialized. This is a stateless class. Constructor
        // has been added to explicitely make this clear.
    }

    public MovieCollection getActualMovies(){
        MovieCollection movieCollection = new MovieCollection();
        ResultSet rs = executeQuery(
            "SELECT movie.id, movie.title, movie.releaseDate, movie.playTime, movie.summary, language.language, `show`.date, `show`.time\n" +
                    "FROM (( movie INNER JOIN `show` ON movie.id = `show`.movieId)\n" +
                    "INNER JOIN language ON language.code = movie.languageCode)\n" +
                    "WHERE `show`.Date >= CURDATE() && `show`.time >= CURTIME();"
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
}
