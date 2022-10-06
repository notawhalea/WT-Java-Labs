package main.code.com.dao.connection;

import main.code.com.exeptions.ConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.DatabaseMetaData;
import java.sql.SQLWarning;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.NClob;
import java.sql.Savepoint;
import java.sql.Array;
import java.sql.SQLClientInfoException;
import java.sql.Struct;
import java.sql.SQLXML;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class ProxyConnection implements Connection {
    private final Connection connection;

    ProxyConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Statement createStatement() throws ConnectionException {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            throw new ConnectionException("Error in createStatement", e);
        }
    }

    void closeConnection() throws ConnectionException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new ConnectionException("Error in closeConnection", e);
        }
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws ConnectionException {
        try {
            return connection.prepareStatement(sql);
        } catch (SQLException e) {
            throw new ConnectionException("Error in prepareStatement", e);
        }
    }

    @Override
    public CallableStatement prepareCall(String sql) throws ConnectionException {
        try {
            return connection.prepareCall(sql);
        } catch (SQLException e) {
            throw new ConnectionException("Error in prepareCall", e);
        }
    }

    @Override
    public String nativeSQL(String sql) throws ConnectionException {
        try {
            return connection.nativeSQL(sql);
        } catch (SQLException e) {
            throw new ConnectionException("Error in nativeSQL", e);
        }
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws ConnectionException {
        try {
            connection.setAutoCommit(autoCommit);
        } catch (SQLException e) {
            throw new ConnectionException("Error in setAutoCommit", e);
        }
    }

    @Override
    public boolean getAutoCommit() throws ConnectionException {
        try {
            return connection.getAutoCommit();
        } catch (SQLException e) {
            throw new ConnectionException("Error in getAutoCommit", e);
        }
    }

    @Override
    public void commit() throws ConnectionException {
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new ConnectionException("Error in commit", e);
        }
    }

    @Override
    public void rollback() throws ConnectionException {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new ConnectionException("Error in rollback", e);
        }
    }

    @Override
    public void close() throws ConnectionException {
        try {
            ConnectionPool.getInstance().releaseConnection(this);
        } catch (SQLException e) {
            throw new ConnectionException("Error in close", e);
        }
    }

    @Override
    public boolean isClosed() throws ConnectionException {
        try {
            return connection.isClosed();
        } catch (SQLException e) {
            throw new ConnectionException("Error in isClosed", e);
        }
    }

    @Override
    public DatabaseMetaData getMetaData() throws ConnectionException {
        try {
            return connection.getMetaData();
        } catch (SQLException e) {
            throw new ConnectionException("Error in getMetaData", e);
        }
    }

    @Override
    public void setReadOnly(boolean readOnly) throws ConnectionException {
        try {
            connection.setReadOnly(readOnly);
        } catch (SQLException e) {
            throw new ConnectionException("Error in setReadOnly", e);
        }
    }

    @Override
    public boolean isReadOnly() throws ConnectionException {
        try {
            return connection.isReadOnly();
        } catch (SQLException e) {
            throw new ConnectionException("Error in isReadOnly", e);
        }
    }

    @Override
    public void setCatalog(String catalog) throws ConnectionException {
        try {
            connection.setCatalog(catalog);
        } catch (SQLException e) {
            throw new ConnectionException("Error in setCatalog", e);
        }
    }

    @Override
    public String getCatalog() throws ConnectionException {
        try {
            return connection.getCatalog();
        } catch (SQLException e) {
            throw new ConnectionException("Error in getCatalog", e);
        }
    }

    @Override
    public void setTransactionIsolation(int level) throws ConnectionException {
        try {
            connection.setTransactionIsolation(level);
        } catch (SQLException e) {
            throw new ConnectionException("Error in setTransactionIsolation", e);
        }
    }

    @Override
    public int getTransactionIsolation() throws ConnectionException {
        try {
            return connection.getTransactionIsolation();
        } catch (SQLException e) {
            throw new ConnectionException("Error in getTransactionIsolation", e);
        }
    }

    @Override
    public SQLWarning getWarnings() throws ConnectionException {
        try {
            return connection.getWarnings();
        } catch (SQLException e) {
            throw new ConnectionException("Error in getWarnings", e);
        }
    }

    @Override
    public void clearWarnings() throws ConnectionException {
        try {
            connection.clearWarnings();
        } catch (SQLException e) {
            throw new ConnectionException("Error in clearWarnings", e);
        }
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency)
            throws ConnectionException {
        try {
            return connection.createStatement(resultSetType, resultSetConcurrency);
        } catch (SQLException e) {
            throw new ConnectionException("Error in createStatement", e);
        }
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
            throws ConnectionException {
        try {
            return connection.prepareStatement(sql, resultSetType, resultSetConcurrency);
        } catch (SQLException e) {
            throw new ConnectionException("Error in prepareStatement", e);
        }
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
            throws ConnectionException {
        try {
            return connection.prepareCall(sql, resultSetType, resultSetConcurrency);
        } catch (SQLException e) {
            throw new ConnectionException("Error in prepareCall", e);
        }
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws ConnectionException {
        try {
            return connection.getTypeMap();
        } catch (SQLException e) {
            throw new ConnectionException("Error in getTypeMap", e);
        }
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws ConnectionException {
        try {
            connection.setTypeMap(map);
        } catch (SQLException e) {
            throw new ConnectionException("Error in setTypeMap", e);
        }
    }

    @Override
    public void setHoldability(int holdability) throws ConnectionException {
        try {
            connection.setHoldability(holdability);
        } catch (SQLException e) {
            throw new ConnectionException("Error in setHoldability", e);
        }
    }

    @Override
    public int getHoldability() throws ConnectionException {
        try {
            return connection.getHoldability();
        } catch (SQLException e) {
            throw new ConnectionException("Error in getHoldability", e);
        }
    }

    @Override
    public Savepoint setSavepoint() throws ConnectionException {
        try {
            return connection.setSavepoint();
        } catch (SQLException e) {
            throw new ConnectionException("Error in setSavepoint", e);
        }
    }

    @Override
    public Savepoint setSavepoint(String name) throws ConnectionException {
        try {
            return connection.setSavepoint(name);
        } catch (SQLException e) {
            throw new ConnectionException("Error in setSavepoint", e);
        }
    }

    @Override
    public void rollback(Savepoint savepoint) throws ConnectionException {
        try {
            connection.rollback(savepoint);
        } catch (SQLException e) {
            throw new ConnectionException("Error in rollback", e);
        }
    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws ConnectionException {
        try {
            connection.releaseSavepoint(savepoint);
        } catch (SQLException e) {
            throw new ConnectionException("Error in releaseSavepoint", e);
        }
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
            throws ConnectionException {
        try {
            return connection.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
        } catch (SQLException e) {
            throw new ConnectionException("Error in createStatement", e);
        }
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
            throws ConnectionException {
        try {
            return connection.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
        } catch (SQLException e) {
            throw new ConnectionException("Error in prepareStatement", e);
        }
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
            throws ConnectionException {
        try {
            return connection.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
        } catch (SQLException e) {
            throw new ConnectionException("Error in prepareCall", e);
        }
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws ConnectionException {
        try {
            return connection.prepareStatement(sql, autoGeneratedKeys);
        } catch (SQLException e) {
            throw new ConnectionException("Error in prepareStatement", e);
        }
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws ConnectionException {
        try {
            return connection.prepareStatement(sql, columnIndexes);
        } catch (SQLException e) {
            throw new ConnectionException("Error in prepareStatement", e);
        }
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws ConnectionException {
        try {
            return connection.prepareStatement(sql, columnNames);
        } catch (SQLException e) {
            throw new ConnectionException("Error in prepareStatement", e);
        }
    }

    @Override
    public Clob createClob() throws ConnectionException {
        try {
            return connection.createClob();
        } catch (SQLException e) {
            throw new ConnectionException("Error in createClob", e);
        }
    }

    @Override
    public Blob createBlob() throws ConnectionException {
        try {
            return connection.createBlob();
        } catch (SQLException e) {
            throw new ConnectionException("Error in createBlob", e);
        }
    }

    @Override
    public NClob createNClob() throws ConnectionException {
        try {
            return connection.createNClob();
        } catch (SQLException e) {
            throw new ConnectionException("Error in createNClob", e);
        }
    }

    @Override
    public SQLXML createSQLXML() throws ConnectionException {
        try {
            return connection.createSQLXML();
        } catch (SQLException e) {
            throw new ConnectionException("Error in createSQLXML", e);
        }
    }

    @Override
    public boolean isValid(int timeout) throws ConnectionException {
        try {
            return connection.isValid(timeout);
        } catch (SQLException e) {
            throw new ConnectionException("Error in isValid", e);
        }
    }

    @Override
    public void setClientInfo(String name, String value) {
        try {
            connection.setClientInfo(name, value);
        } catch (SQLClientInfoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setClientInfo(Properties properties) {
        try {
            connection.setClientInfo(properties);
        } catch (SQLClientInfoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getClientInfo(String name) throws ConnectionException {
        try {
            return connection.getClientInfo(name);
        } catch (SQLException e) {
            throw new ConnectionException("Error in getClientInfo", e);
        }
    }

    @Override
    public Properties getClientInfo() throws ConnectionException {
        try {
            return connection.getClientInfo();
        } catch (SQLException e) {
            throw new ConnectionException("Error in getClientInfo", e);
        }
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws ConnectionException {
        try {
            return connection.createArrayOf(typeName, elements);
        } catch (SQLException e) {
            throw new ConnectionException("Error in createArrayOf", e);
        }
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws ConnectionException {
        try {
            return connection.createStruct(typeName, attributes);
        } catch (SQLException e) {
            throw new ConnectionException("Error in createStruct", e);
        }
    }

    @Override
    public void setSchema(String schema) throws ConnectionException {
        try {
            connection.setSchema(schema);
        } catch (SQLException e) {
            throw new ConnectionException("Error in setSchema", e);
        }
    }

    @Override
    public String getSchema() throws ConnectionException {
        try {
            return connection.getSchema();
        } catch (SQLException e) {
            throw new ConnectionException("Error in getSchema", e);
        }
    }

    @Override
    public void abort(Executor executor) throws ConnectionException {
        try {
            connection.abort(executor);
        } catch (SQLException e) {
            throw new ConnectionException("Error in abort", e);
        }
    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws ConnectionException {
        try {
            connection.setNetworkTimeout(executor, milliseconds);
        } catch (SQLException e) {
            throw new ConnectionException("Error in setNetworkTimeout", e);
        }
    }

    @Override
    public int getNetworkTimeout() throws ConnectionException {
        try {
            return connection.getNetworkTimeout();
        } catch (SQLException e) {
            throw new ConnectionException("Error in getNetworkTimeout", e);
        }
    }


    @Override
    public <T> T unwrap(Class<T> iface) throws ConnectionException {
        try {
            return connection.unwrap(iface);
        } catch (SQLException e) {
            throw new ConnectionException("Error in unwrap", e);
        }
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws ConnectionException {
        try {
            return connection.isWrapperFor(iface);
        } catch (SQLException e) {
            throw new ConnectionException("Error in isWrapperFor", e);
        }
    }
}
