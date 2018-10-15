package datastorage;

import domain.PriceCategory;
import domain.Show;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TicketDAO extends DAO {

    public ArrayList<PriceCategory> getTicketTypes(){
        ArrayList<PriceCategory> ticketTypes = new ArrayList<>();
        ResultSet rs = executeQuery(
            "SELECT * FROM priceCategory;"
        );

        if (rs != null){
            try{
                while (rs.next()) {
                    String name = rs.getString("category");
                    BigDecimal amount = rs.getBigDecimal("amount");

                    ticketTypes.add(new PriceCategory(name, amount));
                }
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
        return ticketTypes;
    }

    //ToDo temporary Show request, need to be moved to ShowDAO
    public HashMap<Integer, Show> getShowsForMovie(int movieId){
        HashMap<Integer, Show> shows = new HashMap<>();
        ResultSet rs = executeQuery(
            "SELECT s.id, s.date, s.time, m.id AS movieId, t.name FROM `show` s " +
            "LEFT JOIN movie m on s.movieId = m.id " +
            "LEFT JOIN room r on s.roomId = r.id " +
            "LEFT JOIN theater t on r.theaterName = t.name " +
            "WHERE m.id = " + movieId + ";"
        );

        if (rs != null){
            try{
                while (rs.next()) {
                    int id = rs.getInt("id");
                    Date date = rs.getDate("date");
                    Time time = rs.getTime("time");
                    //movieId is method's parameter
                    String theaterName = rs.getString("name");

                    shows.put(id, new Show(id, date, time, movieId, theaterName));
                }
            } catch(SQLException e){
                e.printStackTrace();
            }
        }

        return shows;
    }
}
