package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class Model {

    public Connection getConnection() {
        Properties props = new Properties();
        FileInputStream fis = null;
        Connection conn = null;
        try {
            fis = new FileInputStream("db.properties");
            props.load(fis);

            conn = DriverManager.getConnection(
                    props.getProperty("DB_URL"),
                    props.getProperty("DB_USERNAME"),
                    props.getProperty("DB_PASSWORD"));

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
