package com.epam.web.command;

import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;


public class LoginCommand implements Command {

    private static final String LOGIN_PAGE = "index.jsp";
    private static final String MAIN_PAGE = "jsp/main.jsp";

    private final UserServiceImpl service;

    public LoginCommand(UserServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Optional<User> user = service.login(login, password);
        CommandResult result;
        if (user.isPresent()) {
            HttpSession session = req.getSession();
            User registeredUser = user.get();
            req.getSession().setAttribute("userId", registeredUser.getId());
            req.getSession().setAttribute("isAdmin", registeredUser.isAdmin());
            result  = CommandResult.redirect(MAIN_PAGE);

        } else {
            req.setAttribute("errorMessage", "Invalid credential ");
            result = CommandResult.forward(LOGIN_PAGE);
        }
        return result;
    }
}
