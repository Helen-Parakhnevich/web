package com.epam.web.dao;

import com.epam.web.entity.User;
import com.epam.web.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException;
    List<User> getAll() throws DaoException;
}
