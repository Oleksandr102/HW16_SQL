package com.company.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connect {

    public Connection getConnected() throws IOException, SQLException {
        Connection connection = null;

            System.out.println("Connecting to database...");

            Properties properties = new Properties();
            FileInputStream inputStream = new FileInputStream("src/main/resources/DB.properties");
            properties.load(inputStream);
            String DB_URL = properties.getProperty("url");
            String USER = properties.getProperty("username");
            String PASS = properties.getProperty("password");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected");

        return connection;
    }
}
