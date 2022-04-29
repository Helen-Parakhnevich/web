package com.epam.web.command;

import com.epam.web.exception.ServiceException;
import com.epam.web.service.LotServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PayLot implements Command{

    private static final String ERROR_PAGE = "/jsp/error-page.jsp";

    private final LotServiceImpl service;

    public PayLot(LotServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        long lotId = Long.parseLong(req.getParameter("lotId"));

        CommandResult result;

        if (service.payLot(lotId)) {
            result = CommandResult.redirect(req.getContextPath() + "/controller?command=waiting_for_payment");
        } else {
            req.setAttribute("errorMessage", "error.delete-lot");
            result = CommandResult.forward(ERROR_PAGE);
        }
        return result;
    }
}
