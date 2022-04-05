package com.epam.web.mapper;

import com.epam.web.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper {

    @Override
    public User map(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(User.ID);
        String firstName = resultSet.getString(User.FIRST_NAME);
        String lastName = resultSet.getString(User.LAST_NAME);
        String login = resultSet.getString(User.LOGIN);
        boolean isAdmin = resultSet.getBoolean(User.IS_ADMIN);
        boolean isBlocked = resultSet.getBoolean(User.IS_BLOCKED);

        return new User(id, firstName, lastName, login, isAdmin, isBlocked);
    }
}
