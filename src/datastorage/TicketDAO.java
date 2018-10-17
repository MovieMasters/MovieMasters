package datastorage;

import com.mysql.cj.jdbc.exceptions.ConnectionFeatureNotAvailableException;
import domain.PriceCategory;
import domain.Show;
import domain.Ticket;
import view.MainFrame;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class TicketDAO extends DAO {

    public ArrayList<PriceCategory> getPriceCategories() {
        ArrayList<PriceCategory> priceCategories = new ArrayList<>();
        String selectQuery = "SELECT * FROM priceCategory;";

        Connection conn = DBConnection.getConnection();
        try (PreparedStatement selectStatement = conn.prepareStatement(selectQuery)) {
            ResultSet rs = selectStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("category");
                BigDecimal amount = rs.getBigDecimal("amount");

                priceCategories.add(new PriceCategory(name, amount));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(MainFrame.getMainFrame().getContentPane(), "Fout tijdens ophalen van prijscategorien in de database.\n " +
                    "Neem contact op met de administrator.", "SQL Fout", JOptionPane.ERROR_MESSAGE);
        }
        return priceCategories;
    }

    public boolean createTickets(HashMap<String, HashMap<Integer, Ticket>> tickets) {
        boolean ret = true;
        String insertQuery = "INSERT INTO `ticket` (`showId`, `accountUsername`, `priceCategoryCategory`, `roomRoomId`) " +
                "VALUES (?,?,?,?)";
        Connection conn = DBConnection.getConnection();
        try (PreparedStatement insertStatement = conn.prepareStatement(insertQuery)) {
            conn.setAutoCommit(false);

            for (Map.Entry<String, HashMap<Integer, Ticket>> ticketMap : tickets.entrySet()) {
                for (Map.Entry<Integer, Ticket> ticket : ticketMap.getValue().entrySet()) {
                    Ticket t = ticket.getValue();
                    insertStatement.setInt(1, t.getShow().getId());
                    insertStatement.setString(2, t.getAccount().getUsername());
                    insertStatement.setString(3, t.getPriceCategory().getName());
                    insertStatement.setInt(4, t.getShow().getRoomId());

                    insertStatement.addBatch();
                    insertStatement.clearParameters();
                }
            }

            insertStatement.executeBatch();
            conn.commit();
        } catch (SQLException e){
            ret = false;
            JOptionPane.showMessageDialog(MainFrame.getMainFrame().getContentPane(), "Er is een fout opgetreden tijdens het opslaan.\n " +
                    "Neem contact op met de administrator.", "Fout", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return ret;
    }
}