package main.code.com.dao.connection;

import main.code.com.exeptions.ConnectionException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private static final String POOL_SIZE = "db.default-pool-size";
    private static final String DB_CONNECTION_PATH = "connection/dbConnection.properties";

    private BlockingQueue<ProxyConnection> availableConnections;
    private BlockingQueue<ProxyConnection> usedConnections;

    public static ConnectionPool getInstance() {
        return Holder.INSTANCE;
    }

    private ConnectionPool() {
    }

    public void initialize() throws ConnectionException {
        try {
            Properties dbProperties = new Properties();
            dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream(DB_CONNECTION_PATH));
            int poolSize = Integer.parseInt(dbProperties.getProperty(POOL_SIZE));
            availableConnections = new ArrayBlockingQueue<>(poolSize);
            usedConnections = new ArrayBlockingQueue<>(poolSize);
            for (int i = 0; i < poolSize; i++) {
                ProxyConnection connection = ConnectionFactory.createConnection(dbProperties);
                availableConnections.add(connection);
            }
        } catch (IOException e) {
            throw new ConnectionException(e.getMessage(), e);
        }

    }

    public void releaseConnection(ProxyConnection proxyConnection) throws ConnectionException {
        if (proxyConnection != null) {
            usedConnections.remove(proxyConnection);
            try {
                availableConnections.put(proxyConnection);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new ConnectionException(e.getMessage(), e);
            }
        }
    }

    public ProxyConnection getConnection() throws ConnectionException {
        ProxyConnection connection;
        try {
            connection = availableConnections.take();
            usedConnections.put(connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ConnectionException(e.getMessage(), e);
        }
        return connection;
    }

    public void destroy() throws ConnectionException {
        try {
            for (ProxyConnection connection : availableConnections) {
                connection.closeConnection();
            }
            for (ProxyConnection connection : usedConnections) {
                connection.closeConnection();
            }
        } catch (SQLException e) {
            throw new ConnectionException(e.getMessage(), e);
        }

    }

    private static class Holder {
        static final ConnectionPool INSTANCE = new ConnectionPool();
    }
}
