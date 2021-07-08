package ua.ithillel;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String login = "postgres";
        String password = "123";
        String url = "jdbc:postgresql://localhost:5432/myjavadb";

        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            System.out.println("Connection got");
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM employee";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getLong("id") + "\t" +
                                resultSet.getString("name") + "\t" +
                                resultSet.getInt("salary") + "\t" +
                                resultSet.getLong("department_id") + "\t" +
                                resultSet.getLong("chief_id")
                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}