package com.nikita.kovalev;

import java.sql.*;

/**
 * The class adds the entered cost data in the database,
 * and then displays the cost data on the screen
 */
public class Ex4 {

    public static final String DB_URL = "jdbc:mysql://localhost:3306/papa_smurf";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "Stalkerfora1";

    public static void main(String... args) {

        args = new String[4];
        args[0] = "1";
        args[1] = "2011-05-10";
        args[2] = "1";
        args[3] = "77000";

        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }

        try(Connection myConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            Statement statement = myConnection.createStatement();

            String query = "INSERT INTO expenses VALUES (" + args[0] + ", '" + args[1] + "', " + args[2] + ", " + args[3] + ");";
            statement.executeUpdate(query);

            query = "SELECT * FROM expenses LEFT JOIN receivers ON receiver = number;";
            statement.executeQuery(query);

            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                System.out.println(result.getInt(1) + " " + result.getDate(2) + " "
                        + result.getString("receivers.name") + " " + result.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
