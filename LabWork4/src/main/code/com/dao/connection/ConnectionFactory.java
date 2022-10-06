package main.code.com.dao.connection;

import main.code.com.exeptions.ConnectionException;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final String DB_URL = "db.url";
    private static final String DB_USER = "db.user";
    private static final String DB_PASSWORD = "db.password";
    private static final String DB_DRIVER = "db.driver";

    static ProxyConnection createConnection(Properties dbProperties) throws ConnectionException {
        ProxyConnection proxyConnection = null;
        try {
            String dbUrl = dbProperties.getProperty(DB_URL);
            String dbUser = dbProperties.getProperty(DB_USER);
            String dbPassword = dbProperties.getProperty(DB_PASSWORD);
            Class.forName(dbProperties.getProperty(DB_DRIVER));
            proxyConnection = new ProxyConnection(DriverManager.getConnection(dbUrl, dbUser, dbPassword));
        } catch (SQLException | ClassNotFoundException e) {
            throw new ConnectionException(e.getMessage(), e);
        }
        return proxyConnection;
    }
}