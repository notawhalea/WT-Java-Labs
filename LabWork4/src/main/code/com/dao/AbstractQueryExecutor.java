package main.code.com.dao;

import main.code.com.dao.connection.ConnectionPool;
import main.code.com.dao.connection.ProxyConnection;
import main.code.com.dao.mapper.RowMapper;
import main.code.com.entity.Identifiable;
import main.code.com.exeptions.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AbstractQueryExecutor<T extends Identifiable> {


    private final RowMapper<T> rowMapper;

    public AbstractQueryExecutor(RowMapper<T> rowMapper) {
        this.rowMapper = rowMapper;
    }

    protected List<T> executeQuery(String query, Object... params) throws DaoException {
        List<T> entities;
        try (PreparedStatement statement = createStatement(query, params);
             ResultSet resultSet = statement.executeQuery()) {
            entities = createEntitiesList(resultSet);
        } catch (SQLException e) {

            throw new DaoException(e.getMessage(), e);
        }
        return entities;
    }

    protected Optional<T> executeQueryForSingleResult(String query, Object... params) throws DaoException {
        List<T> items = executeQuery(query, params);
        if (items.isEmpty()) {
            return Optional.empty();
        }

        if (!(items.size() == 1)) {
            return Optional.empty();
        }

        return Optional.of(items.get(0));
    }

    protected int executeInsertQuery(String query, Object... params) throws DaoException {
       int result = 0;
        try (PreparedStatement statement = createStatement(query, params)) {
            statement.executeUpdate();
            ResultSet generatedKey = statement.getGeneratedKeys();
            if (generatedKey.next()) {
                result = generatedKey.getInt(1);
            }
        } catch (SQLException e) {

            throw new DaoException(e.getMessage(), e);
        }
        return result;
    }

    protected void executeUpdateQuery(String query, Object... params) throws DaoException {
        try (PreparedStatement statement = createStatement(query, params)) {
            statement.executeUpdate();
        } catch (SQLException e) {

            throw new DaoException(e.getMessage(), e);
        }
    }

    private PreparedStatement createStatement(String query, Object... params) throws DaoException {
        try {
            ProxyConnection proxyConnection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = proxyConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            ConnectionPool.getInstance().releaseConnection(proxyConnection);
            return preparedStatement;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    private List<T> createEntitiesList(ResultSet resultSet) throws DaoException {
        List<T> entities = new ArrayList<>();
        try {
            while (resultSet.next()) {
                T entity = rowMapper.map(resultSet);
                entities.add(entity);
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e);
        }
        return entities;
    }
}
