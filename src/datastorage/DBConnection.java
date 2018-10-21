package datastorage;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DBConnection {

    private static Connection connection;

    /**
     * Creates database properties file
     * @param url the connection url
     * @param dbUsername the database username
     * @param dbPassword the database password
     */
    private static void createPropertiesFile(String url, String dbUsername, String dbPassword){
        Properties prop = new Properties();
        OutputStream output = null;

        try{
            output = new FileOutputStream("db.properties");

            // Set properties
            prop.setProperty("DB_URL", url);
            prop.setProperty("DB_USERNAME", dbUsername);
            prop.setProperty("DB_PASSWORD", dbPassword);

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

    /**
     * Gets the sql.Connection if exists otherwise creates one
     * @return java.sql.Connection the connection object
     */
    public static Connection getConnection() {
        if (connection == null) {
            try (FileInputStream fis = new FileInputStream("db.properties")){
                Properties properties = new Properties();
                if(fis != null)
                {
                    properties.load(fis);
                    connection = DriverManager.getConnection(
                            properties.getProperty("DB_URL"),
                            properties.getProperty("DB_USERNAME"),
                            properties.getProperty("DB_PASSWORD"));
                }
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
     * Closes the current connection if open
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
