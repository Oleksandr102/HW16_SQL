package com.company.logic;

import java.sql.*;

public class Database {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:mem:default;DB_CLOSE_DELAY=-1";

    static final String USER = "user";
    static final String PASS = "";

    public static void createDB() {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

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
            System.out.println("Created table STUDENT");

            inserts(statement);
            selects(statement);
            orderByAge(statement);
            countEntries(statement);
            searchByName(statement);
            desiredAge(statement);

            statement.close();
            connection.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException se2) {

            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("ByeBye!");
    }

    static void inserts(Statement statement) throws SQLException {
        String sql = "INSERT INTO Students " + "VALUES (1, 'Max', 'Max', 'Kyiv', 20)";
        statement.executeUpdate(sql);

        sql = "INSERT INTO Students " + "VALUES (2, 'John', 'John', 'Kyiv', 25)";
        statement.executeUpdate(sql);

        sql = "INSERT INTO Students " + "VALUES (3, 'Oleg', 'Oleg', 'Kyiv', 17)";
        statement.executeUpdate(sql);

        sql = "INSERT INTO Students " + "VALUES (4, 'Tom', 'Tom', 'Kyiv', 47)";
        statement.executeUpdate(sql);

        System.out.println("Added data.");
    }

    static void selects(Statement statement) throws SQLException {
        String sql = "SELECT id, first_name, last_name, age, City FROM Students";
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
        String sql = "SELECT * " +
                "FROM Students " +
                "ORDER BY age DESC";
        ResultSet rs = statement.executeQuery(sql);

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
        String sql = "SELECT COUNT(*) AS total FROM Students";
        ResultSet rs = statement.executeQuery(sql);

        System.out.println("Number of entries ");

        while (rs.next()) {
        int count = rs.getInt("total");
        System.out.println(count);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    static void searchByName(Statement statement) throws SQLException {
        String sql = "SELECT * " +
                "FROM Students " +
                "WHERE first_name LIKE 'J%'";
        ResultSet rs = statement.executeQuery(sql);

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
        String sql = "DELETE " +
                "FROM Students " +
                "WHERE age BETWEEN 20 AND 45";
        statement.executeUpdate(sql);

        System.out.println("Age between 20 and 45 ");
        countEntries(statement);
    }
}
