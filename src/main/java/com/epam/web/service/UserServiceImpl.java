package com.epam.web.service;

import com.epam.web.Controller;
import com.epam.web.dao.DaoHelper;
import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.dao.UserDao;
import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private DaoHelperFactory daoHelperFactory;

    private final Logger LOGGER = LogManager.getLogger(Controller.class);

    public UserServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public Optional<User> login(String login, String password) throws ServiceException {

        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            UserDao userDao = daoHelper.createUserDao();
            Optional<User> user = userDao.findUserByLoginAndPassword(login,password);
            return user;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }
}
