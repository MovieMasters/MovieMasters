package domain;

import java.util.ArrayList;
import java.util.List;

public class Theater {
    private String name;
    private String street;
    private int houseNr;
    private String houseNrAdd;
    private String postcode;
    private String city;
    private String province;
    private int phoneNr;
    private List<Room> rooms;


    Theater(String name, String street, int houseNr, String houseNrAdd, String postcode, String city, String province, int phoneNr) {
        this.name = name;
        this.street = street;
        this.houseNr = houseNr;
        this.houseNrAdd = houseNrAdd;
        this.postcode = postcode;
        this.city = city;
        this.province = province;
        this.phoneNr = phoneNr;
        this.rooms = new ArrayList<>();
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getStreet() {
        return street;
    }

    void setStreet(String street) {
        this.street = street;
    }

    int getHouseNr() {
        return houseNr;
    }

    void setHouseNr(int houseNr) {
        this.houseNr = houseNr;
    }

    String getHouseNrAdd() {
        return houseNrAdd;
    }

    void setHouseNrAdd(String houseNrAdd) {
        this.houseNrAdd = houseNrAdd;
    }

    String getPostcode() {
        return postcode;
    }

    void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    String getCity() {
        return city;
    }

    void setCity(String city) {
        this.city = city;
    }

    String getProvince() {
        return province;
    }

    void setProvince(String province) {
        this.province = province;
    }

    int getPhoneNr() {
        return phoneNr;
    }

    void setPhoneNr(int phoneNr) {
        this.phoneNr = phoneNr;
    }

    List<Room> getRooms() {
        return rooms;
    }

    void addRoom(Room room){
        this.rooms.add(room);
    }
}


