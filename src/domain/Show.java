package domain;

import java.sql.Date;
import java.sql.Time;

public class Show {
    private int id;
    private Date date;
    private Time time;
    private Movie movie;
    private Room room;

    public Show(int id, Date date, Time time, Movie movie, Room room) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.movie = movie;
        this.room = room;
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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
