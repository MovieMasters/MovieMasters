package datastorage;

import domain.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO extends DAO {

    public AccountDAO() {
        // Nothing to be initialized. This is a stateless class. Constructor
        // has been added to explicitely make this clear.
    }

    public void insertDateValue(){

    }

    /**
     * Gets the account from the database by username
     *
     * @param username the primary key of the account
     * @return the Account object to be found. In case account could not be found,
     * null is returned.
     */
    public Account find(String username) {
        Account account = null;
        ResultSet rs = executeQuery("SELECT * FROM account WHERE username = '" + username + "';");
        if (rs != null) {
            try {
                // The username for a account is unique, so in case the
                // resultset does contain data, we need its first entry.
                if (rs.next()) {
                    String firstname = rs.getString("firstName");
                    String lastname = rs.getString("lastName");
                    char[] password = rs.getString("password").toCharArray();
                    String emailaddress = rs.getString("emailaddress");

                    account = new Account(
                            username,
                            password,
                            emailaddress,
                            firstname,
                            lastname);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return account;
    }

    /**
     * Gets the account from the database by username and password
     *
     * @param username the primary key of the account
     * @param password the primary key of the account
     * @return the Account object to be found. In case account could not be found,
     * null is returned.
     */
    public Account login(String username, char[] password) {
        Account account = null;
        //ToDo should be prepared statement
        ResultSet rs = executeQuery("SELECT * FROM `account` WHERE `username` = '" + username + "' AND `password` = '" + new String(password) + "';");
        if (rs != null) {
            try {
                if (rs.next()) {
                    String firstname = rs.getString("firstName");
                    String lastname = rs.getString("lastName");
                    String emailaddress = rs.getString("emailaddress");

                    account = new Account(
                            username,
                            password,
                            emailaddress,
                            firstname,
                            lastname);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return account;
    }

    /**
     * Removes the given account from the database.
     *
     * @param account an object of the Account class
     * @return true if execution of the SQL-statement was successful, false
     * otherwise.
     */
    public boolean remove(Account account) {
        boolean result = false;
        if (account != null) {
            //ToDo Delete account through preparedStatement
        }
        return result;
    }
}
