package com.company.logic;

import java.sql.*;

public class DatabaseOperations {

    static void inserts(Statement statement) throws SQLException {
        String sqlInput = "INSERT INTO Students (id, first_name, last_name, City, age) VALUES" +
                "(1, 'Max', 'Max', 'Kyiv', 20)," +
                "(2, 'John', 'John', 'Kyiv', 25)," +
                "(3, 'Oleg', 'Oleg', 'Kyiv', 17)," +
                "(4, 'Tom', 'Tom', 'Kyiv', 47)";
        statement.executeUpdate(sqlInput);

        System.out.println("Data added to the table.");
    }

    static void selects(Statement statement) throws SQLException {
        String sql = "SELECT * FROM Students";
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("id");
            int age = rs.getInt("age");
            String first = rs.getString("first_name");
            String last = rs.getString("last_name");
            String city = rs.getString("City");

            System.out.print("ID: " + id);
            System.out.print(", Age: " + age);
            System.out.print(", First: " + first);
            System.out.print(", Last: " + last);
            System.out.println(", City: " + city);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    static void orderByAge(Statement statement) throws SQLException {
        String sqlInput = "SELECT * " +
                "FROM Students " +
                "ORDER BY age DESC";
        ResultSet rs = statement.executeQuery(sqlInput);

        System.out.println("Ordered by AGE");

        while (rs.next()) {
            int id = rs.getInt("id");
            int age = rs.getInt("age");
            String first = rs.getString("first_name");
            String last = rs.getString("last_name");
            String city = rs.getString("City");

            System.out.print("ID: " + id);
            System.out.print(", Age: " + age);
            System.out.print(", First: " + first);
            System.out.print(", Last: " + last);
            System.out.println(", City: " + city);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    static void countEntries(Statement statement) throws SQLException {
        String sqlInput = "SELECT COUNT(*) AS total FROM Students";
        ResultSet rs = statement.executeQuery(sqlInput);

        System.out.println("Number of entries ");

        while (rs.next()) {
            int count = rs.getInt("total");
            System.out.println(count);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    static void searchByName(Statement statement) throws SQLException {
        String sqlInput = "SELECT * " +
                "FROM Students " +
                "WHERE first_name LIKE 'J%'";
        ResultSet rs = statement.executeQuery(sqlInput);

        System.out.println("Name starts with 'J' ");

        while (rs.next()) {
            int id = rs.getInt("id");
            int age = rs.getInt("age");
            String first = rs.getString("first_name");
            String last = rs.getString("last_name");
            String city = rs.getString("City");

            System.out.print("ID: " + id);
            System.out.print(", Age: " + age);
            System.out.print(", First: " + first);
            System.out.print(", Last: " + last);
            System.out.println(", City: " + city);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    static void desiredAge(Statement statement) throws SQLException {
        String sqlInput = "DELETE " +
                "FROM Students " +
                "WHERE age BETWEEN 20 AND 45";
        statement.executeUpdate(sqlInput);

        System.out.println("Age between 20 and 45 ");
        countEntries(statement);
    }
}
