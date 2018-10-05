package datastorage;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DBConnection {

    private static Connection connection;

    /**
     * Creates a connection if not exists, otherwise returns the current connection
     *
     * @return the Connection object
     */
    private static void createPropertiesFile(){
        Properties prop = new Properties();
        OutputStream output = null;

        try{
            output = new FileOutputStream("db.properties");

            // Set properties
            prop.setProperty("DB_URL", "jdbc\\:mysql\\://178.251.31.13\\:3306/liannela_moviemasters?serverTimezone=UTC");
            prop.setProperty("DB_USERNAME", "liannela_movieAPI");
            prop.setProperty("DB_PASSWORD", "CeGLEIZa");

            // Save properties in root folder
            prop.store(output, null);
        } catch(IOException io){
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
//                DBConnection.createPropertiesFile();
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
