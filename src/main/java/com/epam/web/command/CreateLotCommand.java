package com.epam.web.command;

import com.epam.web.exception.ServiceException;
import com.epam.web.service.LotServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateLotCommand implements Command {

    private static final String ERROR_PAGE = "/jsp/error-page.jsp";

    private final LotServiceImpl service;

    public CreateLotCommand(LotServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        HttpSession session = req.getSession();
//        Long lotId = Long.parseLong(req.getParameter("lotId"));
//        Optional<Lot> lot = new LotServiceImpl(new DaoHelperFactory()).create(lotId);
//        Long userId = (Long) session.getAttribute("userId");
//        BigDecimal bidSum = new BigDecimal(req.getParameter("bidSum"));
//        Timestamp bidDate = new Timestamp(System.currentTimeMillis());
//        Bid newBid = new Bid(0L,lotId,userId,bidDate,bidSum);

        CommandResult result;
//        if (service.create(newBid) & lot.isPresent()) {
//            req.setAttribute("lotId", lotId);
//            result  = CommandResult.forward("/controller?command=show_lot");
//        } else {
//            req.setAttribute("errorMessage", "");
           result = CommandResult.forward(ERROR_PAGE);
//        }
        return result;
    }
}
