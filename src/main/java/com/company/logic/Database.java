package com.company.logic;

import com.company.connection.Connect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static com.company.logic.DatabaseOperations.*;

public class Database {

    public void dropDB() throws SQLException {

        System.out.println("Creating table");
        statement = connection.createStatement();
        String sql = "CREATE TABLE Students " +
                "(id INTEGER not NULL, " +
                " first_name VARCHAR(255), " +
                " last_name VARCHAR(255), " +
                " City VARCHAR(255), " +
                " age INTEGER, " +
                " PRIMARY KEY (id))";
        statement.executeUpdate(sql);
        System.out.println("Created table Students");

        inserts(statement);
        selects(statement);
        orderByAge(statement);
        countEntries(statement);
        searchByName(statement);
        desiredAge(statement);

        statement.close();
        connection.close();

        System.out.println("ByeBye!");
    }
}
