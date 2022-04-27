package com.epam.web.command;

import com.epam.web.entity.LotBase;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.LotServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class AllRequestLotCommand implements  Command {
    private static final String REQUEST_TABLE = "/jsp/request_table.jsp";

    private final LotServiceImpl service;

    public AllRequestLotCommand(LotServiceImpl service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {

        List<LotBase> lots = new ArrayList<>();
        lots = service.getRequestLot();
        req.setAttribute("lots", lots);
        return CommandResult.forward(REQUEST_TABLE);

    }
}
