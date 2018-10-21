package datastorage;

import domain.*;
import view.MainFrame;

import javax.swing.*;
import java.sql.*;
import java.sql.Date;
import java.time.*;
import java.util.*;

public class MovieDAO extends DAO{
    public MovieDAO() {
        // Nothing to be initialized. This is a stateless class. Constructor
        // has been added to explicitely make this clear.
    }

    /**
     * Gets the movies where there will be shows within the future
     *
     * @return MovieCollection object with movies
     */
    public MovieCollection getActualMovies(){
        MovieCollection movieCollection = new MovieCollection();
        String query =    "SELECT movie.id, movie.title, movie.releaseDate, movie.playTime, movie.summary, `language`.language FROM " +
                                "movie INNER JOIN (`language`, `show`) ON (`language`.code = movie.languageCode AND `show`.movieId = movie.id) WHERE `show`.date >= CURDATE() AND `show`.time > CURTIME()";
        Connection conn = DBConnection.getConnection();
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                Date releaseDate = rs.getDate("releaseDate");
                int playTime = rs.getInt("playTime");
                String summary = rs.getString("summary");
                String language = rs.getString("language");

                Movie movie = new Movie(id, title, releaseDate, playTime, summary, language );
                movieCollection.addMovie(movie);
            }
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(MainFrame.getMainFrame().getContentPane(), "Fout tijdens het ophalen van de filmcollectie uit de database.\nNeem contact op met de administrator.", "Fout", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return movieCollection;
    }

    /**
     * Gets the movie by id
     * @param  movieId the id of the movie
     * @return Movie object
     */
    public Movie find(int movieId){
        Movie movie = null;
        String query = "SELECT movie.id, movie.title, movie.releaseDate, movie.playTime, movie.summary, language.language FROM movie INNER JOIN language ON language.code = movie.languageCode WHERE movie.id = ?";
        Connection conn = DBConnection.getConnection();
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, movieId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                Date releaseDate = rs.getDate("releaseDate");
                int playTime = rs.getInt("playTime");
                String summary = rs.getString("summary");
                String language = rs.getString("language");

                movie = new Movie(id, title, releaseDate, playTime, summary, language, getCastMembers(id), getShows(id) );
            }
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(MainFrame.getMainFrame().getContentPane(), "Fout tijdens het ophalen van de film uit de database.\nNeem contact op met de administrator.", "Fout", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return movie;
    }

    /**
     * Gets the cast members by movie id
     * @param  movieId the id of the movie
     * @return List of cast members
     */
    public List<CastMember> getCastMembers(int movieId){
        List<CastMember> castMembers = new ArrayList<>();
        String query = "SELECT mc.castMemberName, mc.roleRole FROM movie_castmember as mc " +
            "WHERE mc.movieId = ?;";
        Connection conn = DBConnection.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, movieId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("castMemberName");
                String role = rs.getString("roleRole");
                CastMember castMember = new CastMember(name, role);
                castMembers.add(castMember);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(MainFrame.getMainFrame().getContentPane(), "Fout tijdens ophalen van castmembers in de database.\n " +
                    "Neem contact op met de administrator.", "Fout", JOptionPane.ERROR_MESSAGE);
        }
        return castMembers;
    }

    /**
     * Gets the shows for movie
     * @param  movieId the id of the movie
     * @return HashMap key -> theater name, value -> ArrayList of shows
     */
    public HashMap<String, ArrayList<Show>> getShows(int movieId){
        HashMap<String, ArrayList<Show>> mapShows = new HashMap<>();
        String query = "SELECT `show`.id, `show`.date, `show`.time, `show`.roomId, `theater`.name as `theater_name` FROM `show` INNER JOIN `room` ON `show`.roomId = `room`.id INNER JOIN `theater` on `room`.theaterName = `theater`.name WHERE `show`.movieId = ? AND `show`.date >= CURDATE() AND `show`.time > CURTIME() ORDER BY `theater`.name";
        Connection conn = DBConnection.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, movieId);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Show> shows = null;
            while (rs.next()) {
                String theater = rs.getString("theater_name");
                if(mapShows.get(theater) == null)
                {
                    shows = new ArrayList<>();
                }

                int id = rs.getInt("id");
                LocalDate date = rs.getDate("date").toLocalDate();
                LocalTime time = rs.getTime("time").toLocalTime().minusHours(1);
                int roomId = rs.getInt("roomId");

                Show show = new Show(id, date, time, movieId, roomId);
                shows.add(show);
                mapShows.put(theater, shows);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(MainFrame.getMainFrame().getContentPane(), "Fout tijdens ophalen van shows in de database.\n " +
                    "Neem contact op met de administrator.", "Fout", JOptionPane.ERROR_MESSAGE);
        }
        return mapShows;
    }
}
