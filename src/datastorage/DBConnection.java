package datastorage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class DBConnection {

    private static Connection connection;

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

    public void closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
