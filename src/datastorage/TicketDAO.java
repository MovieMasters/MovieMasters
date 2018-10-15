package datastorage;

import domain.PriceCategory;
import domain.Show;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TicketDAO extends DAO {

    public ArrayList<PriceCategory> getTicketTypes() {
        ArrayList<PriceCategory> ticketTypes = new ArrayList<>();
        ResultSet rs = executeQuery(
                "SELECT * FROM priceCategory;"
        );

        if (rs != null) {
            try {
                while (rs.next()) {
                    String name = rs.getString("category");
                    BigDecimal amount = rs.getBigDecimal("amount");

                    ticketTypes.add(new PriceCategory(name, amount));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ticketTypes;
    }
}