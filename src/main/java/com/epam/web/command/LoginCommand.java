package com.epam.web.command;

import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.entity.Category;
import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.CategoryServiceImpl;
import com.epam.web.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
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
        CategoryServiceImpl categoryService = new CategoryServiceImpl(new DaoHelperFactory());
        List<Category> categories = categoryService.getAll();
        CommandResult result;
        if (user.isPresent()) {
            HttpSession session = req.getSession();
            User registeredUser = user.get();
            session.setAttribute("userId", registeredUser.getId());
            session.setAttribute("isAdmin", registeredUser.isAdmin());
            session.setAttribute("categories", categories);
            result  = CommandResult.redirect(MAIN_PAGE);

        } else {
            req.setAttribute("errorMessage", "Invalid credential ");
            result = CommandResult.forward(LOGIN_PAGE);
        }
        return result;
    }
}
