package com.epam.web.connection;

import com.epam.web.Controller;
import com.epam.web.exception.ConfigException;
import com.epam.web.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionFactory {

    private static String PROPERTIES_FILE = "/config.properties";

    private final String driver;
    private final String url;
    private final String login;
    private final String password;
    private final int poolSize;

    public ConnectionFactory() {
        Properties prop = readPropertiesFile();
        this.driver = prop.getProperty("driver");
        this.url = prop.getProperty("url");
        this.login = prop.getProperty("login");
        this.password = prop.getProperty("password");
        this.poolSize = Integer.parseInt(prop.getProperty("pool_size"));
    }

    public int getPoolSize() {
        return poolSize;
    }

    private final Logger LOGGER = LogManager.getLogger(Controller.class);

    public List<ProxyConnection> create(ConnectionPool pool) throws DaoException {

        List<ProxyConnection> proxyConnections = new ArrayList<>(poolSize);
        for (int i = 1; i <= poolSize; i++) {
            try {
                Class.forName(driver);
                Connection connection = DriverManager.getConnection(url, login, password);
                ProxyConnection proxyConnection = new ProxyConnection(connection, pool);
                proxyConnections.add(proxyConnection);
            } catch (SQLException | ClassNotFoundException e) {
                LOGGER.error("Error creating DB connection", e);
                throw new DaoException(e);
            }
        }
        return proxyConnections;
    }

    private Properties readPropertiesFile() throws ConfigException {
        try {
            Properties prop = new Properties();
            InputStream inputStream = ConnectionFactory.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);
            prop.load(inputStream);
            return prop;
        } catch (IOException e) {
            LOGGER.error("Not found property file ", e);
            throw new ConfigException(e);
        }
    }

}
