package com.epam.web.connection;

import com.epam.web.Controller;
import com.epam.web.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    private static final Integer POOL_SIZE = 20;
    private static final String URL = "jdbc:mysql://localhost:3306/auction";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "123qwe123";

    private static ConnectionPool instance;

    private Queue<ProxyConnection> connectionsAvailable;
    private Queue<ProxyConnection> connectionsInUse;
    private ReentrantLock connectionLock = new ReentrantLock();

    private final Logger LOGGER = LogManager.getLogger(Controller.class);

    private ConnectionPool() {
        connectionsAvailable = new ArrayDeque<>(POOL_SIZE);
        connectionsInUse = new ArrayDeque<>(POOL_SIZE);
    }

    private void init() throws ServiceException {
        for (int i = 1; i <= POOL_SIZE; i++) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction",
                        "root", "123qwe123");
                ProxyConnection proxyConnection = new ProxyConnection(connection, this);
                connectionsAvailable.offer(proxyConnection);
                LOGGER.info("Connection " + i + " added to pool.");
            } catch (SQLException|ClassNotFoundException e) {
                LOGGER.error("Error creating DB connection", e);
                throw new ServiceException(e);
            }
        }
    }

    public static ConnectionPool getInstance() throws ServiceException {
        ConnectionPool localInstance = instance;
        if (localInstance == null) {
            synchronized (ConnectionPool.class) {
                localInstance = instance;
                if (localInstance == null) {
                    localInstance = new ConnectionPool();
                    localInstance.init();
                    instance = localInstance;
                }
            }
        }
        return instance;
    }

    public void returnConnection(ProxyConnection proxyConnection) {
        connectionLock.lock();
        try {
            if (connectionsInUse.contains(proxyConnection)) {
                connectionsAvailable.offer(proxyConnection);
                connectionsInUse.remove(proxyConnection);
            }
        } finally {
            connectionLock.unlock();
        }
    }

    public ProxyConnection getConnection() {
        ProxyConnection connection = null;
        connectionLock.lock();
        try {
            if (connectionsAvailable.size() > 0) {
                connection = connectionsAvailable.poll();
                connectionsInUse.offer(connection);
            }
        } finally {
            connectionLock.unlock();
        }
        return connection;
    }
}
