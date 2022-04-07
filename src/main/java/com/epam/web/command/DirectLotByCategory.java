package com.epam.web.command;

import com.epam.web.entity.Lot;
import com.epam.web.entity.LotType;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.LotServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class DirectLotByCategory implements Command {
    private static final String CATALOG_PAGE = "/jsp/catalog.jsp";

    private final LotServiceImpl service;

    public DirectLotByCategory(LotServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String categoryId = req.getParameter("categoryId");
        long id;
        if (categoryId!= null) {
            id = Integer.parseInt(categoryId);
        } else {
            id = 0;
        }
        List<Lot> lots = new ArrayList<>();
        if (id!=0) {
            lots = service.getDirectByCategory(id);
        } else {
            lots = service.getCurrentByType(LotType.DIRECT);
        }
        req.setAttribute("lots", lots);
        req.setAttribute("type", "direct");
        return CommandResult.forward(CATALOG_PAGE);
    }
}
