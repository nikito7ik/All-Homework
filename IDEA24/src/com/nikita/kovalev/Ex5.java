package com.nikita.kovalev;

import java.sql.*;

/**
 * Changed Ex4, now the class uses the recompiled queries
 */
public class Ex5 {

    public static final String DB_URL = "jdbc:mysql://localhost:3306/papa_smurf";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "Stalkerfora1";

    public static void main(String... args) {

        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }

        try(Connection myConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {

            String template = "SELECT * FROM expenses WHERE value > ?";

            PreparedStatement preparedStatement = myConnection.prepareStatement(template);
            preparedStatement.setFloat(1, 10000.0F);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                System.out.println(result.getInt(1) + " " + result.getDate(2) + " "
                        + result.getString(3) + " " + result.getFloat(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
