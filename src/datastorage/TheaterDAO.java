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

    public boolean create(String name, String street, int houseNumber, String houseNrAdd, String postcode, String city, String province, int phoneNr) {
        boolean ret = true;
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

    public boolean delete(Theater theater) {
        boolean ret = true;
        String deleteQuery = "DELETE FROM `theater` WHERE `name` = ?";
        Connection conn = DBConnection.getConnection();
        try (PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery)) {
            conn.setAutoCommit(false);
            deleteStatement.setString(1, theater.getName());
            deleteStatement.execute();
            conn.commit();

        } catch (SQLException e) {
            ret = false;
            JOptionPane.showMessageDialog(MainFrame.getMainFrame().getContentPane(), "Er is een fout opgetreden tijdens het ophalen.\n " +
                    "Neem contact op met de administrator.", "Fout", JOptionPane.ERROR_MESSAGE);
        }
        return ret;
    }

}
