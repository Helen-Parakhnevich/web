package com.epam.web.command;

import com.epam.web.exception.ServiceException;
import com.epam.web.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlockUnblockUserCommand implements Command {

    private static final String ERROR_PAGE = "/jsp/error-page.jsp";

    private final UserServiceImpl service;

    public BlockUnblockUserCommand(UserServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        long userId = Long.parseLong(req.getParameter("userId"));

        CommandResult result;

        if (service.blockUnblockUser(userId)) {
            result = CommandResult.redirect(req.getContextPath() + "/controller?command=all_user");
        } else {
            req.setAttribute("errorMessage", "error.block-user");
            result = CommandResult.forward(ERROR_PAGE);
        }
        return result;
    }
}
