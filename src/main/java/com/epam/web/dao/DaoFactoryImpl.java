package com.epam.web.dao;

import com.epam.web.exception.DaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class DaoFactoryImpl implements DaoFactory<Connection> {

    private String USER = "root";
    private String PASSWORD = "123qwe123";
    private String URL = "jdbc:mysql://localhost:3306/auction";
    private String DRIVER = "com.mysql.jdbc.Driver";
    private Map<Class, DaoCreator> creators;

    public Connection getContext() throws DaoException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return  connection;
    }

    @Override
    public Dao getDao(Connection connection, Class dtoClass) throws DaoException {
        DaoCreator creator = creators.get(dtoClass);
        if (creator == null) {
            throw new DaoException("Dao object for " + dtoClass + " not found.");
        }
        return creator.create(connection);
    }
}


