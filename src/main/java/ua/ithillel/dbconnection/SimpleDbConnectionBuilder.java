package ua.ithillel.dbconnection;

import ua.ithillel.util.AppConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleDbConnectionBuilder implements DbConnectionBuilder {

    public SimpleDbConnectionBuilder() {
        try {
            Class.forName(AppConfig.getProperty("db.driver"));
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        String url = AppConfig.getProperty("db.url");
        String login = AppConfig.getProperty("db.login");
        String password = AppConfig.getProperty("db.password");
        return DriverManager.getConnection(url, login, password);
    }
}
