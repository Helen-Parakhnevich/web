package com.epam.web.command;

import com.epam.web.entity.LotBase;
import com.epam.web.entity.LotType;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.LotServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateLotCommand implements Command {

    private static final String ERROR_PAGE = "/jsp/error-page.jsp";

    private final LotServiceImpl service;

    public CreateLotCommand(LotServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        HttpSession session = req.getSession(false);
        Long userId = (Long) session.getAttribute("userId");
        String title = req.getParameter(LotBase.TITLE);
//        Locale locale = (Locale) session.getAttribute("locale");
        Long categoryId = Long.parseLong(req.getParameter(LotBase.CATEGORY_ID));
        LotType type = LotType.getTypeByTitle(req.getParameter(LotBase.TYPE));
        BigDecimal startPrice = new BigDecimal(req.getParameter(LotBase.START_PRICE));
        LocalDateTime dateStart;
        LocalDateTime dateEnd;
        CommandResult result;
        try {
            dateStart = stringToLocalDateTime(req.getParameter(LotBase.DATE_START));;
            dateEnd = stringToLocalDateTime(req.getParameter(LotBase.DATE_END));
        } catch (ParseException e) {
            throw new ServiceException(e);
        }

        LotBase newLot = new LotBase(0L, categoryId, type, title, startPrice, dateStart, dateEnd, userId);

        if (service.create(newLot)) {
            result  = CommandResult.redirect("/controller?command=direct_lot_by_category");
        } else {
           req.setAttribute("errorMessage", "");
           result = CommandResult.forward(ERROR_PAGE);
        }
        return result;
    }

    private LocalDateTime stringToLocalDateTime(String dateTime) throws ParseException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.from(dateTimeFormatter.parse(dateTime));
        return localDateTime;
    }

}
