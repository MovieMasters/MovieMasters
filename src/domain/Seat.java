package domain;

public class Seat extends Model {
    private int id;
    private int roomId;
    private String seatType;
    private char seatRow;
    private int seatNumber;

    public Seat(int id, int roomId, String seatType, char seatRow, int seatNumber) {
        this.id = id;
        this.roomId = roomId;
        this.seatType = seatType;
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
    }

    public int getId() {
        return id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public char getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(char seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
