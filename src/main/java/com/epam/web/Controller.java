package com.epam.web;

import com.epam.web.command.Command;
import com.epam.web.command.CommandFactory;
import com.epam.web.command.CommandResult;
import com.epam.web.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    private static final String ERROR_PAGE = "/jsp/error.jsp";
    private final Logger LOGGER = LogManager.getLogger(Controller.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command");
        CommandFactory factoryCommand = new CommandFactory();
        Command action = null;
        try {
            action = factoryCommand.create(command);
        } catch (ServiceException e) {
            LOGGER.error("Unknown command " + command, e);
            req.setAttribute("errorMessage", e.getMessage());
            dispatch(req, resp, CommandResult.forward(ERROR_PAGE));
            throw new ServletException(e);
        }
        try {
            CommandResult result = action.execute(req, resp);
            dispatch(req, resp, result);
        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());
            dispatch(req, resp, CommandResult.forward(ERROR_PAGE));
            LOGGER.error("Failed to execute command " + command, e);
        }
    }

    private void dispatch(HttpServletRequest req, HttpServletResponse resp, CommandResult result) throws ServletException, IOException {
        String page = result.getPage();
        if (!result.isRedirect()) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect(page);
        }
    }

}
