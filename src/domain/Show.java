package domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Show extends Model{
    private int id;
    private LocalDate date;
    private LocalTime time;
    private int movieId;
    private int roomId;

    public Show(int id, LocalDate date, LocalTime time, int movieId, int roomId) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.movieId = movieId;
        this.roomId = roomId;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
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
}
