package model;

import model.Room;

import java.util.ArrayList;

public class Theather {
    private String name;
    private String street;
    private int houseNr;
    private String houseNrAdd;
    private String postcode;
    private String city;
    private String province;
    private int phoneNr;
    private ArrayList<Room> rooms;


    public Theather(String name, String street, int houseNr, String houseNrAdd, String postcode, String city, String province, int phoneNr) {
        this.name = name;
        this.street = street;
        this.houseNr = houseNr;
        this.houseNrAdd = houseNrAdd;
        this.postcode = postcode;
        this.city = city;
        this.province = province;
        this.phoneNr = phoneNr;
        this.rooms = new ArrayList<Room>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNr() {
        return houseNr;
    }

    public void setHouseNr(int houseNr) {
        this.houseNr = houseNr;
    }

    public String getHouseNrAdd() {
        return houseNrAdd;
    }

    public void setHouseNrAdd(String houseNrAdd) {
        this.houseNrAdd = houseNrAdd;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(int phoneNr) {
        this.phoneNr = phoneNr;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
}


