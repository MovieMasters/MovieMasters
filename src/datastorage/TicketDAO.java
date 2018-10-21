package datastorage;

import domain.PriceCategory;
import domain.Show;
import view.MainFrame;
import javax.swing.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

public class TicketDAO extends DAO {

    public TicketDAO() {
        // Nothing to be initialized. This is a stateless class. Constructor
        // has been added to explicitely make this clear.
    }

    /**
     * Gets an ArrayList of available price categories
     * @return ArrayList of price categories
     */
    public ArrayList<PriceCategory> getPriceCategories() {
        ArrayList<PriceCategory> priceCategories = new ArrayList<>();
        String query = "SELECT category, amount FROM priceCategory;";

        Connection conn = DBConnection.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("category");
                BigDecimal amount = rs.getBigDecimal("amount");

                priceCategories.add(new PriceCategory(name, amount));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(MainFrame.getMainFrame().getContentPane(), "Fout tijdens ophalen van prijs categorieën in de database.\n " +
                    "Neem contact op met de administrator.", "SQL Fout", JOptionPane.ERROR_MESSAGE);
        }
        return priceCategories;
    }

    /**
     * Creates a theater with the specified parameters
     *
     * @param tickets HashMap key -> PriceCategory, value -> amount of tickets
     * @param show the selected show to order the tickets for
     * @return boolean indicating the result of the statement
     */
    public boolean createTickets(HashMap<PriceCategory, Integer> tickets, Show show) {
        boolean ret = true;
        String query = "INSERT INTO `ticket` (`showId`, `accountUsername`, `priceCategoryCategory`, `roomRoomId`) " +
                "VALUES (?,?,?,?)";
        Connection conn = DBConnection.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            conn.setAutoCommit(false);

            for (Map.Entry<PriceCategory, Integer> entry : tickets.entrySet()) {
                PriceCategory priceCategory = entry.getKey();
                Integer amount = entry.getValue();

                for(int i = 0; i < amount; i++) {
                    stmt.setInt(1, show.getId());
                    stmt.setString(2, MainFrame.getMainFrame().getCachedUser().getUsername());
                    stmt.setString(3, priceCategory.getName());
                    stmt.setInt(4, show.getRoomId());
                    stmt.addBatch();
                    stmt.clearParameters();
                }
            }
            stmt.executeBatch();
            conn.commit();
        } catch (SQLException e){
            ret = false;
            JOptionPane.showMessageDialog(MainFrame.getMainFrame().getContentPane(), "Er is een fout opgetreden tijdens het opslaan van de tickets.\n " +
                    "Neem contact op met de administrator.", "Fout", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return ret;
    }
}