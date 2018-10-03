package datastorage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {
    /**
     * @param query The SQL query that will be executed
     * @return true if execution of the SQL statement was successful, false
     * otherwise.
     */
    public ResultSet executeQuery(String query) {
        ResultSet rs = null;
        if (query != null) {
            try {
                Connection conn = DBConnection.getConnection();
                if (conn != null) {
                    Statement stmt = conn.createStatement();
                    rs = stmt.executeQuery(query);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }
}
