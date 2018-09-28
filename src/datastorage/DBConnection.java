package datastorage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class DBConnection {

    private Connection connection;

    // The Statement object has been defined as a field because some methods
    // may return a ResultSet object. If so, the statement object may not
    // be closed as you would do when it was a local variable in the query
    // execution method.
    private Statement statement;

    public DBConnection() {
        connection = null;
        statement = null;
    }

    public boolean openConnection() {
        boolean result = false;
        Properties properties = new Properties();
        FileInputStream fis = null;
        if (connection == null) {
            try {
                fis = new FileInputStream("db.properties");
                properties.load(fis);
                connection = DriverManager.getConnection(
                        properties.getProperty("DB_URL"),
                        properties.getProperty("DB_USERNAME"),
                        properties.getProperty("DB_PASSWORD"));

                if (connection != null) {
                    statement = connection.createStatement();
                }

                result = true;
            } catch (SQLException e) {
                System.out.println(e);
                result = false;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // A connection was already initalized.
            result = true;
        }

        return result;
    }

    public boolean connectionIsOpen() {
        boolean open = false;

        if (connection != null && statement != null) {
            try {
                open = !connection.isClosed() && !statement.isClosed();
            } catch (SQLException e) {
                System.out.println(e);
                open = false;
            }
        }
        // Else, at least one the connection or statement fields is null, so
        // no valid connection.

        return open;
    }

    public void closeConnection() {
        try {
            statement.close();

            // Close the connection
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet executeSQLSelectStatement(String query) {
        ResultSet resultset = null;

        // First, check whether a some query was passed and the connection with
        // the database.
        if (query != null && connectionIsOpen()) {
            // Then, if succeeded, execute the query.
            try {
                resultset = statement.executeQuery(query);
            } catch (SQLException e) {
                System.out.println(e);
                resultset = null;
            }
        }

        return resultset;
    }

    /**
     * Dml: data manipulation language
     *
     * @param query The SQL query that will be executed
     * @return true if execution of the SQL statement was successful, false
     * otherwise.
     */
    public boolean executeSqlDmlStatement(String query) {
        boolean result = false;

        // First, check whether a some query was passed and the connection with
        // the database.
        if (query != null && connectionIsOpen()) {
            // Then, if succeeded, execute the query.
            try {
                statement.executeUpdate(query);
                result = true;
            } catch (SQLException e) {
                System.out.println(e);
                result = false;
            }
        }

        return result;
    }
}
