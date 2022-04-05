package com.epam.web.service;

import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> login(String login, String password) throws ServiceException;
    List<User> getAll() throws ServiceException;
}
