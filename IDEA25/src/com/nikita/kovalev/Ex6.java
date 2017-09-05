package com.nikita.kovalev;

import java.sql.*;

/**
 * Created by nikit on 05.09.2017.
 * Working with the database
 */
public class Ex6 {

    public static final String DB_URL = "jdbc:mysql://localhost:3306/papa_smurf";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "Stalkerfora1";

    public static void main(String... args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }

        try (Connection myConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            Statement statement = myConnection.createStatement();

            System.out.println("-----We display the list of payees, and the amount of payments for each of them-----");

            String template = "SELECT receivers.name, SUM(value) AS sum FROM expenses " +
                    "RIGHT JOIN receivers ON receiver = number GROUP BY receiver;";
            ResultSet result = statement.executeQuery(template);

            while (result.next()) {
                System.out.println(result.getString("receivers.name") + " " + result.getFloat("sum"));
            }

            System.out.println("-----We display the amount of payments for the day when there was the largest payment-----");

            String template2 = "SELECT SUM(value) AS sum FROM expenses " +
                    "WHERE payday=(SELECT payday FROM expenses " +
                    "WHERE value=(SELECT MAX(value) FROM expenses));";
            ResultSet result2 = statement.executeQuery(template2);

            while (result2.next()) {
                System.out.println(result2.getFloat(1));
            }

            System.out.println("-----We display the largest payment for the day when the amount of payments was the largest-----");

            String template3 = "SELECT  e.num, e.payday, r.name, e.value FROM expenses AS e " +
                    "RIGHT JOIN (SELECT payday FROM (SELECT payday, SUM(value) AS sum FROM expenses " +
                    "GROUP BY payday) AS s ORDER BY sum DESC LIMIT 1) AS d ON e.payday = d.payday " +
                    "RIGHT JOIN receivers AS r ON e.receiver = r.number ORDER BY value DESC LIMIT 1;";
            ResultSet result3 = statement.executeQuery(template3);

            while (result3.next()) {
                System.out.println(result3.getInt(1) + " " + result3.getDate(2) + " "
                        + result3.getString(3) + " " + result3.getInt(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
