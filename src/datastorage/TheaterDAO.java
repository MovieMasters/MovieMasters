package datastorage;


import java.sql.ResultSet;

import domain.Theater;
import view.MainFrame;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TheaterDAO extends DAO {

    public TheaterDAO() {
        // Nothing to be initialized. This is a stateless class. Constructor
        // has been added to explicitely make this clear.
    }

    /**
     * Gets the Theater by id
     * @param  name the name of the theater
     * @return Theater object
     */
    public Theater find(String name) {
        Theater theater = null;
        String selectQuery = "SELECT `name`, `street`, `houseNr`, `houseNrAdd`, `postcode`, `city`, `province`, `phone`" +
                "FROM `theater` WHERE `name` = ?";
        Connection conn = DBConnection.getConnection();
        try (PreparedStatement selectStatement = conn.prepareStatement(selectQuery)) {
            selectStatement.setString(1, name);
            ResultSet rs = selectStatement.executeQuery();
            if (rs.next()) {
                theater = new Theater(rs.getString("name"),
                        rs.getString("street"),
                        rs.getInt("houseNr"),
                        rs.getString("houseNrAdd"),
                        rs.getString("postcode"),
                        rs.getString("city"),
                        rs.getString("province"),
                        rs.getInt("phone"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(MainFrame.getMainFrame().getContentPane(), "Fout tijdens ophalen van theater in de database.\n " +
                    "Neem contact op met de administrator.", "Fout", JOptionPane.ERROR_MESSAGE);
        }
        return theater;
    }

    /**
     * Creates a theater with the specified parameters
     *
     * @param name the name of the theater
     * @param street the adres street name
     * @param houseNumber the adres house number
     * @param houseNrAdd the house number addition
     * @param postcode the postcode
     * @param city the city
     * @param province the province
     * @param phoneNr the phone number
     * @return boolean indicating the result of the statement
     */
    public boolean create(String name, String street, int houseNumber, String houseNrAdd, String postcode, String city, String province, int phoneNr) {
        boolean ret = true;
        String query = "INSERT INTO `theater` (`name`, `street`, `houseNr`, `houseNrAdd`, `postcode`, `city`, `province`, `phone`)" +
                "VALUES (?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            conn.setAutoCommit(false);
            stmt.setString(1, name);
            stmt.setString(2, street);
            stmt.setInt(3, houseNumber);
            stmt.setString(4, houseNrAdd);
            stmt.setString(5, postcode);
            stmt.setString(6, city);
            stmt.setString(7, province);
            stmt.setInt(8, phoneNr);
            stmt.execute();
            conn.commit();
        } catch (SQLException e) {
            ret = false;
            if (e.getErrorCode() == 1406) {
                JOptionPane.showMessageDialog(MainFrame.getMainFrame().getContentPane(), "Theater: " + name + " bestaat al.", "Dubbele invoer", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(MainFrame.getMainFrame().getContentPane(), "Er is een fout opgetreden tijdens het opslaan.\n " +
                        "Neem contact op met de administrator.", "Fout", JOptionPane.ERROR_MESSAGE);
            }
        }
        return ret;
    }

    /**
     * Deletes the given theater from the database.
     *
     * @param theater an object of the Theater class
     * @return true if execution of the SQL-statement was successful, false
     * otherwise.
     */
    public boolean delete(Theater theater) {
        boolean ret = true;
        String query = "DELETE FROM `theater` WHERE `name` = ?";
        Connection conn = DBConnection.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            conn.setAutoCommit(false);
            stmt.setString(1, theater.getName());
            stmt.execute();
            conn.commit();
        } catch (SQLException e) {
            ret = false;
            JOptionPane.showMessageDialog(MainFrame.getMainFrame().getContentPane(), "Er is een fout opgetreden tijdens het ophalen.\n " +
                    "Neem contact op met de administrator.", "Fout", JOptionPane.ERROR_MESSAGE);
        }
        return ret;
    }

}
