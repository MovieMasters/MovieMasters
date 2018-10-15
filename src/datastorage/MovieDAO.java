package datastorage;

import domain.*;
import view.MainFrame;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;;

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
                    "       `language`.language\n" +
                    "FROM\n" +
                    "      movie\n" +
                    "         INNER JOIN `language` \n" +
                    "         ON `language`.code = movie.languageCode;"
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
                        language,
                        getCastMembers(id),
                        getShows(id)
                    );
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return movie;
    }

    public List<CastMember> getCastMembers(int movieId){
        List<CastMember> castMembers = new ArrayList<>();
        String selectQuery = "SELECT mc.castMemberName, mc.roleRole FROM movie_castmember as mc " +
            "WHERE mc.movieId = ?;";
        Connection conn = DBConnection.getConnection();
        try (PreparedStatement selectStatement = conn.prepareStatement(selectQuery)) {
            selectStatement.setInt(1, movieId);
            ResultSet rs = selectStatement.executeQuery();
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

    public List<Show> getShows(int movieId){
        List<Show> shows = new ArrayList<>();
        String selectQuery = "SELECT `show`.id, `show`.date, `show`.time, `show`.roomId FROM `show` " +
                "WHERE `show`.movieId = ?;";
        Connection conn = DBConnection.getConnection();
        try (PreparedStatement selectStatement = conn.prepareStatement(selectQuery)) {
            selectStatement.setInt(1, movieId);
            ResultSet rs = selectStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                Date date = rs.getDate("date");
                Time time = rs.getTime("time");
                int roomId = rs.getInt("roomId");
                //Movieid is parameter

                Show show = new Show(id,date,time, movieId,roomId);
                shows.add(show);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(MainFrame.getMainFrame().getContentPane(), "Fout tijdens ophalen van castmembers in de database.\n " +
                    "Neem contact op met de administrator.", "Fout", JOptionPane.ERROR_MESSAGE);
        }
        return shows;
    }


}
