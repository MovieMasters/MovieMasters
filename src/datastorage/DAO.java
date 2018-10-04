package datastorage;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public abstract class DAO {
    /**
     * @param query The SQL query that will be executed
     * @return Resultset
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

    /**
     * @param query The prepared statement that will be executed
     */
    public void executePreparedStatement(String query) {
        ResultSet rs = null;
        if (query != null) {
            try {
                Connection conn = DBConnection.getConnection();
                if (conn != null) {
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.execute();
                    conn.commit();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
