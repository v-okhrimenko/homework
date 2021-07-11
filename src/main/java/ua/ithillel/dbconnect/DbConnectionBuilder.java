package ua.ithillel.dbconnect;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnectionBuilder {
    Connection getConnection() throws SQLException;
}
