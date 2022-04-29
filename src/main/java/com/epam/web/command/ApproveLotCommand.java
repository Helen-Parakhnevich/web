package com.epam.web.command;

import com.epam.web.exception.ServiceException;
import com.epam.web.service.LotServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApproveLotCommand implements Command {

    private static final String ERROR_PAGE = "/jsp/error-page.jsp";

    private final LotServiceImpl service;

    public ApproveLotCommand(LotServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        Long lotId = Long.parseLong(req.getParameter("lotId"));

        CommandResult result;

        if (service.approveLot(lotId)) {
            result = CommandResult.redirect(req.getContextPath() + "/controller?command=all_request");
        } else {
            req.setAttribute("errorMessage", "error.approve-lot");
            result = CommandResult.forward(ERROR_PAGE);
        }
        return result;
    }
}
