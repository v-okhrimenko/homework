package ua.ithillel.dbconnect;

import org.apache.commons.dbcp2.BasicDataSource;
import ua.ithillel.util.AppConfig;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class PoolDbConnectionBuilder implements DbConnectionBuilder {

    private BasicDataSource dataSource;

    public PoolDbConnectionBuilder() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName(AppConfig.getProperty("db.driver"));
        dataSource.setUrl(AppConfig.getProperty("db.url"));
        dataSource.setUsername(AppConfig.getProperty("db.login"));
        dataSource.setPassword(AppConfig.getProperty("db.password"));
        dataSource.setMinIdle(5);
        dataSource.setInitialSize(10); // количество коннектов
        dataSource.setMaxOpenPreparedStatements(100);
    }

    @Override
    public Connection getConnection() throws SQLException {
//        String login = AppConfig.getProperty("db.login");
//        String password = AppConfig.getProperty("db.password");
//        String url = AppConfig.getProperty("db.url");
//        Connection connection = DriverManager.getConnection(url, login, password);
        Connection connection = dataSource.getConnection();
        if (Objects.nonNull(connection)) {
            System.out.println("Connection got");
        }
        return connection;
    }
}
