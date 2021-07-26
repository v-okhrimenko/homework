package ua.ithillel.servlet;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import ua.ithillel.dbconnection.ConnectionBuilderFactory;
import ua.ithillel.dbconnection.DbConnectionBuilder;
import ua.ithillel.dbconnection.PoolDbConnectionBuilder;
import ua.ithillel.util.AppConfig;

@WebListener
public class InitWebListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContextListener was created!");
        AppConfig.initAppConfig();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContextListener was destroyed!");
        DbConnectionBuilder dbConnectionBuilder = ConnectionBuilderFactory.getInstance().getDbConnectionBuilder();
        if (dbConnectionBuilder instanceof PoolDbConnectionBuilder) {
            ((PoolDbConnectionBuilder) dbConnectionBuilder).closeDataSource();
        }
    }
}
