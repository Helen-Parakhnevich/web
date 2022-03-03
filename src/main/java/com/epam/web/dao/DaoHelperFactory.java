package com.epam.web.dao;

import com.epam.web.Controller;
import com.epam.web.connection.ConnectionPool;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DaoHelperFactory {
    private final Logger LOGGER = LogManager.getLogger(Controller.class);

    public DaoHelper create() throws DaoException {
        try {
            return new DaoHelper(ConnectionPool.getInstance());
        } catch (ServiceException e) {
          throw new DaoException(e);
        }
    }
}
