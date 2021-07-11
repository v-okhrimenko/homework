package ua.ithillel.dbconnect;

public class ConnectionBuilderFactory {

    public static DbConnectionBuilder getConnectionBuilder() {
        return new SimpleDbConnectionBuilder();
    }
}
