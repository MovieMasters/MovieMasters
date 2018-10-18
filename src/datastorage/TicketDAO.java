package datastorage;

import com.mysql.cj.jdbc.exceptions.ConnectionFeatureNotAvailableException;
import domain.Movie;
import domain.PriceCategory;
import domain.Show;
import domain.Ticket;
import view.MainFrame;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
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

    public boolean createTickets(HashMap<PriceCategory, Integer> tickets, Show show) {
        boolean ret = true;
        String insertQuery = "INSERT INTO `ticket` (`showId`, `accountUsername`, `priceCategoryCategory`, `roomRoomId`) " +
                "VALUES (?,?,?,?)";
        Connection conn = DBConnection.getConnection();
        try (PreparedStatement insertStatement = conn.prepareStatement(insertQuery)) {
            conn.setAutoCommit(false);

            for (Map.Entry<PriceCategory, Integer> entry : tickets.entrySet()) {
                PriceCategory priceCategory = entry.getKey();
                Integer amount = entry.getValue();

                for(int i = 0; i < amount; i++) {
                    insertStatement.setInt(1, show.getId());
                    insertStatement.setString(2, MainFrame.getMainFrame().getCachedUser().getUsername());
                    insertStatement.setString(3, priceCategory.getName());
                    insertStatement.setInt(4, show.getRoomId());
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