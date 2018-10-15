package domain;

import java.sql.Date;
import java.sql.Time;

public class Show {
    private int id;
    private Date date;
    private Time time;
    private int movieId;
    private String theaterName;

    public Show(int id, Date date, Time time, int movieId, String theatername) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.movieId = movieId;
        this.theaterName = theatername;
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

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }
}
