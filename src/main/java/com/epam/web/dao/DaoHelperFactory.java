package com.epam.web.dao;

import com.epam.web.Controller;
import com.epam.web.connection.ConnectionPool;
import com.epam.web.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DaoHelperFactory {

    private final Logger LOGGER = LogManager.getLogger(Controller.class);

    public DaoHelper create() throws DaoException {

        return new DaoHelper(ConnectionPool.getInstance());

    }
}

