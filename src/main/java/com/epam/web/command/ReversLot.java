package com.epam.web.command;

import com.epam.web.entity.Lot;
import com.epam.web.entity.LotType;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.LotServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ReversLot implements Command {

    private static final String CATALOG_PAGE = "jsp/catalog.jsp";

    private final LotServiceImpl service;

    public ReversLot(LotServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {

        List<Lot> lots = new ArrayList<>();
        lots = service.getCurrentByType(LotType.REVERSE);
        req.getSession().setAttribute("lots", lots);
        req.getSession().setAttribute("type", "reverse");
        return CommandResult.redirect(CATALOG_PAGE);

    }
}
