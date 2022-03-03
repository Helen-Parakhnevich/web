package com.epam.web.dao;

import com.epam.web.entity.User;
import com.epam.web.exception.DaoException;
import com.epam.web.mapper.UserRowMapper;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    public static final String TABLE = "user";

    public static final String ID = "id";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String IS_ADMIN = "is_admin";

    private static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM USER WHERE login = ? AND PASSWORD = ?";

    public UserDaoImpl(Connection connection) {
        super(connection, new UserRowMapper(), TABLE);
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException{
        return executeForSingleResult(FIND_BY_LOGIN_AND_PASSWORD, new UserRowMapper(), login, password);
    }

    @Override
    public Optional<User> getById(long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() throws DaoException {
        return executeQuery("SELECT * FROM user", new UserRowMapper());
    }

    @Override
    protected String getTableName() {
        return User.TABLE;
    }

    @Override
    public Optional<User> create() throws DaoException {
        return Optional.empty();
    }

    @Override
    public void save(User object) throws DaoException {

    }

    @Override
    public Optional<User> removeById(Long id) throws DaoException {
        return Optional.empty();
    }

    protected  Map<String, Object> getFields(User item) {
        Map<String, Object> fields = new HashMap<>();
        fields.put(User.ID, item.getId());
        fields.put(User.FIRST_NAME, item.getFirstName());
        fields.put(User.LAST_NAME, item.getLastName());
        fields.put(User.LOGIN, item.getLogin());
        fields.put(User.IS_ADMIN, item.isAdmin());
        return fields;
    }
}

