package com.epam.web.command;

import com.epam.web.entity.LotBase;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.LotServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class AllLotCommand implements Command {

    private static final String LOT_TABLE = "jsp/lot_table.jsp";

    private final LotServiceImpl service;

    public AllLotCommand(LotServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {

        List<LotBase> lots = new ArrayList<>();
        lots = service.getAll();
        req.getSession().setAttribute("lots", lots);
        return CommandResult.redirect(LOT_TABLE);

    }

}
