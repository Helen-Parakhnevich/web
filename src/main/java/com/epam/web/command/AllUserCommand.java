package com.epam.web.command;

import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class AllUserCommand implements Command {
    private static final String USER_TABLE = "jsp/user_table.jsp";

    private final UserServiceImpl service;

    public AllUserCommand(UserServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {

        List<User> users = new ArrayList<>();
        users = service.getAll();
        req.getSession().setAttribute("users", users);
        return CommandResult.redirect(USER_TABLE);

    }
}
