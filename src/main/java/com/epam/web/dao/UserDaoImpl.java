package com.epam.web.dao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.entity.User;
import com.epam.web.exception.DaoException;
import com.epam.web.mapper.UserRowMapper;

import java.util.HashMap;
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
    public static final String IS_BLOCKED = "is_admin";

    private static final String FILTER_NOT_DELETED = " AND is_deleted='0' ";
    private static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM USER WHERE login = ? AND PASSWORD = ?" + FILTER_NOT_DELETED;
    private static final String CREATE_USER = "INSERT INTO USER (first_name, last_name, login, password, is_admin)" +
            "values(?, ?, ?, ?, ?)";
    private static final String BLOCK_UNBLOCK_USER = "UPDATE USER SET is_blocked= not is_blocked WHERE id = ?";

    public UserDaoImpl(ProxyConnection connection) {
        super(connection, new UserRowMapper(), TABLE);
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException{
        return executeForSingleResult(FIND_BY_LOGIN_AND_PASSWORD, new UserRowMapper(), login, password);
    }

    @Override
    public boolean blockUnblockUser(long id) throws DaoException {
        executeQueryNoResult(BLOCK_UNBLOCK_USER, id);
        return true;
    }

    @Override
    public boolean create(User user) throws DaoException {
       String firstName = user.getFirstName();
       String lastName = user.getLastName();
       String login = user.getLogin();
       String password = user.getPassword();
       Boolean isAdmin = user.getIsAdmin();
       executeQueryNoResult(CREATE_USER, firstName, lastName, login, password, isAdmin);
       return true;
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
        fields.put(User.IS_ADMIN, item.getIsAdmin());
        fields.put(User.IS_BLOCKED, item.getIsAdmin());
        return fields;
    }

    @Override
    protected String getTableName() {
        return User.TABLE;
    }

    @Override
    protected String getRowMapperTableName() {
        return User.TABLE;
    }
}

