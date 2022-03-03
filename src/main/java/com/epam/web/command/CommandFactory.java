package com.epam.web.command;

import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.UserServiceImpl;

public class CommandFactory {

    public Command create(String command) throws ServiceException {
        switch (command) {
            case "login":
                return new LoginCommand(new UserServiceImpl(new DaoHelperFactory()));
            case "logout": new LogoutCommand();
            case "catalog":
                return new CatalogCommand();
            case "some_page":
                return new ShowPageCommand("some_page");
            default:
                throw new IllegalArgumentException("Unknown command = " + command);
        }
    }

}
