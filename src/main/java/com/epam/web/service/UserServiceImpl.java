package com.epam.web.service;

import com.epam.web.dao.DaoHelper;
import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.dao.UserDao;
import com.epam.web.entity.User;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private DaoHelperFactory daoHelperFactory;

    private final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    public UserServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public Optional<User> login(String login, String password) throws ServiceException {

        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            UserDao userDao = daoHelper.createUserDao();
            Optional<User> user = userDao.findUserByLoginAndPassword(login,password);
            return user;
        } catch (DaoException e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getAll() throws ServiceException {
        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            UserDao userDao = daoHelper.createUserDao();
            List<User> users = userDao.getAll();
            return users;
        } catch (DaoException e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<User> getById(Long id) throws ServiceException {
        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            UserDao userDao = daoHelper.createUserDao();
            Optional<User> user = userDao.getById(id);
            return user;
        } catch (DaoException e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean createUser(User user) throws ServiceException {
        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            daoHelper.startTransaction();
            UserDao userDao = daoHelper.createUserDao();
            daoHelper.endTransaction();
            return userDao.create(user);
        } catch (DaoException e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean blockUnblockUser(long id) throws ServiceException {
        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            daoHelper.startTransaction();
            UserDao userDao = daoHelper.createUserDao();
            daoHelper.endTransaction();
            return userDao.blockUnblockUser(id);
        } catch (DaoException e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteUser(long id) throws ServiceException {
        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            daoHelper.startTransaction();
            UserDao userDao = daoHelper.createUserDao();
            boolean successDelete = userDao.delete(id);
            daoHelper.endTransaction();
            return successDelete;
        } catch (DaoException e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }
}
