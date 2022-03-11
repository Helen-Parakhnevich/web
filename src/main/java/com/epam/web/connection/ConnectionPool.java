package com.epam.web.connection;

import com.epam.web.Controller;
import com.epam.web.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    private static ConnectionPool instance;

    private Queue<ProxyConnection> connectionsAvailable;
    private Queue<ProxyConnection> connectionsInUse;
    private ReentrantLock connectionLock = new ReentrantLock();

    private ConnectionFactory connectionFactory = new ConnectionFactory();

    private final Logger LOGGER = LogManager.getLogger(Controller.class);

    private ConnectionPool() {
        int poolSize = connectionFactory.getPoolSize();
        connectionsAvailable = new ArrayDeque<>(poolSize);
        connectionsInUse = new ArrayDeque<>(poolSize);
    }

    private void init() throws DaoException {

        List<ProxyConnection> connections = connectionFactory.create(this);
        connectionsAvailable.addAll(connections);
    }

    public static ConnectionPool getInstance() throws DaoException {
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
