package com.epam.web.command;

import com.epam.web.entity.Lot;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.LotServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ForPaymentLot implements Command {

    private static final String LOT_PAYMENT_TABLE = "/jsp/lot_payment_table.jsp";

    private final LotServiceImpl service;

    public ForPaymentLot(LotServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {

        HttpSession session = req.getSession();
        Long userId = (Long) session.getAttribute("userId");
        List<Lot> lots = service.getEndedDirectUnpaid(userId);
        req.setAttribute("lots", lots);
        return CommandResult.forward(LOT_PAYMENT_TABLE);

    }

}
