package datastorage;

import domain.Theater;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheaterDAOTest extends DAO {
    Theater testTheater;
    TheaterDAO theaterDAO;

    @BeforeEach
    void setUp() {
        theaterDAO = new TheaterDAO();
        testTheater = new Theater("TestTheater",
                "TestStreet",
                1,
                "a",
                "4421aa",
                "TestCity",
                "TestProvince",
                1);
    }

    @AfterEach
    void tearDown(){
        theaterDAO = null;
        testTheater = null;
    }

    @Test
    void createFindDelete() {
        create();
        find();
        delete();
    }

    void create() {
        boolean result = theaterDAO.create(testTheater.getName(),
                testTheater.getStreet(),
                testTheater.getHouseNr(),
                testTheater.getHouseNrAdd(),
                testTheater.getPostcode(),
                testTheater.getCity(),
                testTheater.getProvince(),
                testTheater.getPhoneNr());
        assertTrue(result);
    }

    void find() {
        Theater theater = theaterDAO.find(testTheater.getName());
        assertNotEquals(theater, null);
    }

    void delete() {
        assertTrue(theaterDAO.delete(testTheater));
    }
}