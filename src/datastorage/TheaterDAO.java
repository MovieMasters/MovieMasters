package datastorage;

import domain.Account;
import domain.Theater;
import view.MainFrame;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TheaterDAO extends DAO {

    public TheaterDAO() {
        // Nothing to be initialized. This is a stateless class. Constructor
        // has been added to explicitely make this clear.
    }

    public Theater create(String name, String street, int houseNumber, String houseNrAdd, String postcode, String city, String province, int phoneNr){
        Theater theater = null;
        String insertQuery = "INSERT INTO `theater` (`name`, `street`, `houseNr`, `houseNrAdd`, `postcode`, `city`, `province`, `phone`)" +
                "VALUES (?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getConnection();
        try (PreparedStatement insertStatement = conn.prepareStatement(insertQuery)) {
            conn.setAutoCommit(false);
            insertStatement.setString(1, name);
            insertStatement.setString(2, street);
            insertStatement.setInt(3, houseNumber);
            insertStatement.setString(4, houseNrAdd);
            insertStatement.setString(5, postcode);
            insertStatement.setString(6, city);
            insertStatement.setString(7, province);
            insertStatement.setInt(8, phoneNr);
            insertStatement.execute();
            conn.commit();

        } catch (SQLException e) {
            if(e.getErrorCode() == 1406){
                JOptionPane.showMessageDialog(MainFrame.getMainFrame().getContentPane(), "Theater: " + name + " bestaat al.", "Dubbele invoer", JOptionPane.ERROR_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(MainFrame.getMainFrame().getContentPane(), "Er is een fout opgetreden tijdens het opslaan.\n " +
                        "Neem contact op met de administrator.", "Fout", JOptionPane.ERROR_MESSAGE);
            }

        }
        return theater;
    }

}
