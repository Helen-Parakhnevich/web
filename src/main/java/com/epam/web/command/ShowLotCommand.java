package com.epam.web.command;

import com.epam.web.entity.Lot;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.LotServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class ShowLotCommand implements Command {

    private static final String LOT_PAGE = "jsp/lot.jsp";
    private static final String ERROR_PAGE = "";

    private final LotServiceImpl service;

    public ShowLotCommand(LotServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        long lotId = Long.parseLong(req.getParameter("lotId"));

        Optional<Lot> lot = service.getByIdWithBid(lotId);

        CommandResult result;
        if (lot.isPresent()) {
            Lot currentLot = lot.get();
            req.getSession().setAttribute("lot", currentLot);
            result  = CommandResult.redirect(LOT_PAGE);

        } else {
            req.setAttribute("errorMessage", "");
            result = CommandResult.forward(ERROR_PAGE);
        }
        return result;
    }
}
