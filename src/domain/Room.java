package domain;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int id;
    private String name;
    private String theaterName;
    private List<Seat> seats;

    public Room(int roomId, String roomName, String theaterName){
        this.id = roomId;
        this.name = roomName;
        this.theaterName = theaterName;
        this.seats = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void addSeat(Seat seat) {
        this.seats.add(seat);
    }
}
