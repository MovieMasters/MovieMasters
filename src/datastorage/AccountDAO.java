package datastorage;

import domain.Account;
import view.MainFrame;

import javax.swing.*;
import java.sql.*;
import java.util.Arrays;

public class AccountDAO extends DAO {

    public AccountDAO() {
        // Nothing to be initialized. This is a stateless class. Constructor
        // has been added to explicitely make this clear.
    }

    /**
     * Gets the account from the database by username
     *
     * @param username the primary key of the account
     * @return the Account object to be found. In case account could not be found,
     * null is returned.
     */
    @SuppressWarnings("Duplicates")
    public Account find(String username) {
        Account account = null;
        String query = "SELECT username, password, emailaddress, firstName, middleName, lastName FROM account WHERE username = ?";
        Connection conn = DBConnection.getConnection();
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                char[] password = rs.getString("password").toCharArray();
                String emailaddress = rs.getString("emailaddress");
                String firstName = rs.getString("firstName");
                String middleName = rs.getString("middleName");
                String lastName = rs.getString("lastName");

                account = new Account(
                        username,
                        password,
                        emailaddress,
                        firstName,
                        middleName,
                        lastName);
            }
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(MainFrame.getMainFrame().getContentPane(), "Fout tijdens het ophalen van de filmcollectie uit de database.\nNeem contact op met de administrator.", "Fout", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return account;
    }

    /**
     * Gets the account from the database by username and password
     *
     * @param username the primary key of the account
     * @param password the primary key of the account
     * @return the Account object to be found where username and password match
     */
    @SuppressWarnings("Duplicates")
    public Account login(String username, char[] password) {
        Account account = find(username);
        if(account != null)
        {
            if(Arrays.equals(account.getPassword(), password))
            {
                return account;
            }
        }
        return null;
    }


    /**
     * Creates an account with the specified parameters
     *
     * @param username the primary key of the account
     * @param password the password of the account
     * @param emailaddress the emailaddress of the account
     * @param firstName the first name of the account
     * @param middleName the middle name of the account
     * @param lastName the last name of the account
     * @return boolean indicating the result of the statement
     */
    public boolean create(String username, char[] password, String emailaddress, String firstName, String middleName, String lastName){
       boolean ret = true;
        String query = "INSERT INTO `account` (username, password, emailaddress, firstName, middleName, lastName) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = DBConnection.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, new String(password));
            stmt.setString(3, emailaddress);
            stmt.setString(4, firstName);
            stmt.setString(5, middleName);
            stmt.setString(6, lastName );
            stmt.execute();
        } catch (SQLException e){
            ret = false;
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * Deletes the given account from the database.
     *
     * @param account an object of the Account class
     * @return true if execution of the SQL-statement was successful, false
     * otherwise.
     */
    public boolean delete(Account account) {
        boolean ret = true;
        if (account != null) {
            String query = "DELETE FROM account WHERE username = ?";
            Connection conn = DBConnection.getConnection();
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, account.getUsername());
                stmt.execute();
            } catch (SQLException e){
                ret = false;
                e.printStackTrace();
            }
        }
        return ret;
    }
}
