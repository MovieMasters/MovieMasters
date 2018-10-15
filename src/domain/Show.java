package domain;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Show extends Model{
    private int id;
    private Date date;
    private Time time;
    private int movieId;
    private int roomId;
//    private List<Ticket> tickets;

    public Show(int id, Date date, Time time, int movieId, int roomId) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.movieId = movieId;
        this.roomId = roomId;
//        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovie(int movieId) {
        this.movieId = movieId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

//    public List<Ticket> getTickets() {
//        return tickets;
//    }
//
//    public void setTickets(List<Ticket> tickets) {
//        this.tickets = tickets;
//    }
}
