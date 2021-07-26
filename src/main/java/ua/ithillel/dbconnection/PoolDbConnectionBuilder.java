package ua.ithillel.dbconnection;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import ua.ithillel.util.AppConfig;

import java.sql.Connection;
import java.sql.SQLException;

public class PoolDbConnectionBuilder implements DbConnectionBuilder {

    private final DataSource dataSource = new DataSource();

    public PoolDbConnectionBuilder() {
        PoolProperties pp = new PoolProperties();
        pp.setDriverClassName(AppConfig.getProperty("db.driver"));
        pp.setUrl(AppConfig.getProperty("db.url"));
        pp.setUsername(AppConfig.getProperty("db.login"));
        pp.setPassword(AppConfig.getProperty("db.password"));
        pp.setMinIdle(5);
        pp.setMaxIdle(10);
        pp.setInitialSize(5);
        dataSource.setPoolProperties(pp);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void closeDataSource() {
        dataSource.close();
    }
}
