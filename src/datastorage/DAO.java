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
     * @param statement The prepared statement that will be executed
     */
    public void executePreparedStatement(String statement) {
        ResultSet rs = null;
        if (statement != null) {
            try {
                Connection conn = DBConnection.getConnection();
                if (conn != null) {
                    PreparedStatement stmt = conn.prepareStatement(statement);
                    stmt.execute();
                    conn.commit();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
