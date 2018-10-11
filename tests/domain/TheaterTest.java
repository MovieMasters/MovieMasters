package domain;

import datastorage.TheaterDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheaterTest extends Model {
    Theater theater;

    @BeforeEach
    void setUp() {
        theater = new Theater("TestTheater",
                "TestStraat",
                1,
                "a",
                "4433JA",
                "TestStad",
                "TestProvincie",
                1234556789);
    }

    @Test
    void getName() {
        assertEquals("TestTheater", theater.getName());
    }

    @Test
    void setName() {
    }

    @Test
    void getStreet() {
    }

    @Test
    void setStreet() {
    }

    @Test
    void getHouseNr() {
    }

    @Test
    void setHouseNr() {
    }

    @Test
    void getHouseNrAdd() {
    }

    @Test
    void setHouseNrAdd() {
    }

    @Test
    void getPostcode() {
    }

    @Test
    void setPostcode() {
    }

    @Test
    void getCity() {
    }

    @Test
    void setCity() {
    }

    @Test
    void getProvince() {
    }

    @Test
    void setProvince() {
    }

    @Test
    void getPhoneNr() {
    }

    @Test
    void setPhoneNr() {
    }

    @Test
    void getRooms() {
    }

    @Test
    void addRoom() {
    }
}