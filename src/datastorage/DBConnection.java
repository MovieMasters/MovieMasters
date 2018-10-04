package datastorage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBConnection {

    private static Connection connection;

    /**
     * Creates a connection if not exists, otherwise returns the current connection
     *
     * @return the Connection object
     */
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Properties properties = new Properties();
                FileInputStream fis = new FileInputStream("db.properties");
                properties.load(fis);
                connection = DriverManager.getConnection(
                        properties.getProperty("DB_URL"),
                        properties.getProperty("DB_USERNAME"),
                        properties.getProperty("DB_PASSWORD"));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * Gets status of the connection
     *
     * @return A boolean that returns true if the current connection is not closed,
     * otherwise false
     */
    public static boolean connectionIsOpen() {
        boolean open = false;
        if (connection != null) {
            try {
                open = !connection.isClosed();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return open;
    }

    /**
     * Closed the current connection if open
     */
    public void closeConnection() {
        try {
            if (connectionIsOpen()) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
