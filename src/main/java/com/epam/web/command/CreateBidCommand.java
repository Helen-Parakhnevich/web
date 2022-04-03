package com.epam.web.command;

import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.entity.Bid;
import com.epam.web.entity.Lot;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.BidServiceImpl;
import com.epam.web.service.LotServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Optional;

public class CreateBidCommand implements Command {

    private static final String LOT_PAGE = "jsp/lot.jsp";
    private static final String ERROR_PAGE = "";

    private final BidServiceImpl service;

    public CreateBidCommand(BidServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        HttpSession session = req.getSession();
        Long lotId = Long.parseLong(req.getParameter("lotId"));
        Optional<Lot> lot = new LotServiceImpl(new DaoHelperFactory()).getByIdWithBid(lotId);
        Long userId = (Long) session.getAttribute("userId");
        BigDecimal bidSum = new BigDecimal(req.getParameter("bidSum"));
        Timestamp bidDate = new Timestamp(System.currentTimeMillis());
        Bid newBid = new Bid(0L,lotId,userId,bidDate,bidSum);

        CommandResult result;
        if (service.create(newBid) & lot.isPresent()) {
            //result  = CommandResult.redirect(LOT_PAGE);

            req.getSession().getServletContext().setAttribute("lotId", lotId);
            result  = CommandResult.forward("/controller?command=show_lot");
        } else {
            req.setAttribute("errorMessage", "");
            result = CommandResult.forward(ERROR_PAGE);
        }
        return result;
    }
}

