//package datastorage;
//
//import domain.Show;
//import domain.ShowCollection;
//
//import java.sql.Date;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Time;
//import java.util.HashMap;
//
//public class ShowDAO extends DAO {
//    public ShowCollection getShowsForMovie(int movieId){
//        ShowCollection showCollection = new ShowCollection();
//        ResultSet rs = executeQuery(
//                "SELECT s.id, s.date, s.time, s.roomId, s.movieId FROM `show` s " +
//                        "WHERE s.movieId = " + movieId + ";"
//        );
//
//        if (rs != null){
//            try{
//                while (rs.next()) {
//                    int id = rs.getInt("id");
//                    Date date = rs.getDate("date");
//                    Time time = rs.getTime("time");
//                    int roomId = rs.getInt("roomId");
//                    //movieId is method's parameter
//
//                    showCollection.addShow(new Show(id, date, time, movieId, roomId));
//                }
//            } catch(SQLException e){
//                e.printStackTrace();
//            }
//        }
//
//        return showCollection;
//    }
//
//    public Show getShow(int showId){
//        Show show = null;
//        ResultSet rs = executeQuery(
//                "SELECT * FROM `show` s " +
//                        "WHERE s.id = " + showId + ";"
//        );
//
//        if (rs != null) {
//            try{
//                while (rs.next()) {
//                    //Id is method's parameter
//                    Date date = rs.getDate("date");
//                    Time time = rs.getTime("time");
//                    int roomId = rs.getInt("roomId");
//                    int movieId = rs.getInt("movieId");
//
//                    show = new Show(showId, date, time, roomId, movieId);
//                }
//            } catch(SQLException e){
//                e.printStackTrace();
//            }
//        }
//        return show;
//    }
//}
