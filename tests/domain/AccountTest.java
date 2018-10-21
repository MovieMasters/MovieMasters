package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest extends Model {
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(
                "testAccount",
                new char[]{'t','e','s','t','P','W'},
                "test@junit.com",
                "FirstTestName",
                "MiddleName",
                "LastTestName"
        );
    }

    @AfterEach
    void tearDown() {
    }

//    @Test
//    void remove() {
//    }
//
    @Test
    void getUsername() {
        assertEquals("testAccount", account.getUsername());
    }

    @Test
    void setUsername() {
        String newUsername = "testAccount2";
        account.setUsername(newUsername);
        assertEquals(newUsername,account.getUsername());
    }

    @Test
    void getPassword() {
        assertEquals("testPW", new String(account.getPassword()));
    }

    @Test
    void setPassword() {
        char[] newPW = new char[]{'n','e','w','P','W'};
        account.setPassword(newPW);
        assertEquals(newPW, account.getPassword());
    }

    @Test
    void getEmailAddress() {
        assertEquals("test@junit.com", account.getEmailAddress());
    }

    @Test
    void setEmailAddress() {
        String newEmail = "jhel@avans.nl";
        account.setEmailAddress(newEmail);
        assertEquals("jhel@avans.nl", account.getEmailAddress());
    }

    @Test
    void getFirstName() {
        assertEquals("FirstTestName", account.getFirstName());
    }

    @Test
    void setFirstName() {
        String newFName = "Jeroen";
        account.setFirstName(newFName);
        assertEquals("Jeroen", account.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("LastTestName", account.getLastName());
    }

    @Test
    void setLastName() {
        String newLName = "van der Hel";
        account.setLastName(newLName);
        assertEquals("van der Hel", account.getLastName());
    }
}