package com.epam.web.dao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.entity.Identifiable;
import com.epam.web.exception.DaoException;
import com.epam.web.mapper.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractDao<T extends Identifiable> implements Dao<T> {

    private final Connection connection;
    private final RowMapper<T> rowMapper;
    private final String table;

    public AbstractDao(ProxyConnection connection, RowMapper<T> rowMapper, String table) {
        this.connection = connection;
        this.rowMapper = rowMapper;
        this.table = table;
    }

    protected List<T> executeQuery(String query, RowMapper<T> mapper, Object... params) throws DaoException {

        try (PreparedStatement statement = createPreparedStatement(query, params);
             ResultSet resultSet = statement.executeQuery()) {
            List<T> entities = new ArrayList<>();
            while (resultSet.next()) {
                T entity = mapper.map(resultSet);
                entities.add(entity);
            }
            return entities;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    protected boolean executeUpdate(String query, Object... params) throws DaoException {

        try (PreparedStatement statement = createPreparedStatement(query, params)) {
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private PreparedStatement createPreparedStatement(String query, Object... params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        for (int i = 1; i <= params.length; i++) {
            statement.setObject(i, params[i - 1]);
        }
        return statement;
    }

    @Override
    public List<T> getAll() throws DaoException {
        String table = getTableName();
        String tableMapper = getRowMapperTableName();
        RowMapper<T> mapper = (RowMapper<T>) RowMapper.create(tableMapper);
        return executeQuery("SELECT * FROM " + table + " WHERE " + table + ". is_deleted='0'", mapper);
    }

    @Override
    public Optional<T> getById(long id) throws DaoException{
        String table = getTableName();
        RowMapper<T> mapper = (RowMapper<T>) RowMapper.create(table);
        return executeForSingleResult("SELECT * FROM " + table + " WHERE " + table + ".id = " + id , mapper);
    }

    @Override
    public boolean save(T item) throws DaoException {
        Map<String, Object> fields = getFields(item);
        String query = item.getId() == null ? generateInsertQuery(fields) : generateUpdateQuery(fields);
        // check sequence order
        executeUpdate(query, fields.values());
        return true;
    }

    @Override
    public boolean delete(long id) throws DaoException{
        String table = getTableName();
        RowMapper<T> mapper = (RowMapper<T>) RowMapper.create(table);
        executeQueryNoResult("UPDATE " + table + " SET is_deleted='1' WHERE " + table + ".id = " + id);
        return true;
    }

    public Optional<T> executeForSingleResult(String query, RowMapper<T> mapper, Object... params) throws DaoException {
        List<T> items = executeQuery(query, mapper, params);
        if (items.size() == 1) {
            return Optional.of(items.get(0));
        } else if (items.size() > 1) {
            throw new IllegalArgumentException("More than one record found");
        } else {
            return Optional.empty();
        }
    }

    public boolean executeQueryNoResult(String query, Object... params) throws DaoException {
        try (PreparedStatement statement = createPreparedStatement(query, params)) {
            statement.execute();
            return true;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    protected abstract Map<String, Object> getFields(T item);

    String generateInsertQuery(Map<String, Object> fields) {
        throw new UnsupportedOperationException();
    }

    String generateUpdateQuery(Map<String, Object> fields) {
        throw new UnsupportedOperationException();
    }

    protected abstract String getTableName();

    protected abstract String getRowMapperTableName();
}


