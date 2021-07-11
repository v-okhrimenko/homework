package ua.ithillel.dbconnect;

import ua.ithillel.util.AppConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class SimpleDbConnectionBuilder implements DbConnectionBuilder {


    public SimpleDbConnectionBuilder() {
        try {
            Class.forName(AppConfig.getProperty("db.driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        String login = AppConfig.getProperty("db.login");
        String password = AppConfig.getProperty("db.password");
        String url = AppConfig.getProperty("db.url");
        Connection connection = DriverManager.getConnection(url, login, password);
        if (Objects.nonNull(connection)) {
            System.out.println("Connection got");
        }
        return connection;
    }
}
