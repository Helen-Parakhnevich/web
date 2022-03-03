package com.epam.web.service;

import com.epam.web.dao.UserDao;
import com.epam.web.entity.User;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;

import java.util.Optional;

public class SimpleUserService implements UserService {

    private UserDao dao;

    public SimpleUserService(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public Optional<User> login(String login, String password) throws ServiceException {
        try {
            Optional<User> user = dao.findUserByLoginAndPassword(login, password);
            return user;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
