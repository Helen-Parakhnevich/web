package com.epam.web.command;

import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateUserCommand implements Command {

    private static final String ERROR_PAGE = "/jsp/error-page.jsp";

    private final UserServiceImpl service;

    public CreateUserCommand(UserServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        HttpSession session = req.getSession(false);

        String firstName = req.getParameter(User.FIRST_NAME);
        String lastName = req.getParameter(User.LAST_NAME);
        String login = req.getParameter(User.LOGIN);
        String password = req.getParameter(User.PASSWORD);
        Boolean isAdmin = Boolean.parseBoolean(req.getParameter(User.IS_ADMIN));

        CommandResult result;

       User newUser = new User(0L, firstName, lastName, login, isAdmin, false);
       newUser.setPassword(password);

        if (service.createUser(newUser)) {
            result  = CommandResult.redirect(req.getContextPath() + "/controller?command=all_user");
        } else {
            req.setAttribute("errorMessage", "error.create-user");
            result = CommandResult.forward(ERROR_PAGE);
        }
        return result;
    }
}
