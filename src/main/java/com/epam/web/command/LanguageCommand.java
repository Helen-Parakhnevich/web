package com.epam.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LanguageCommand implements Command {

    private final String language;

    private static final String CURRENT_PAGE = "/jsp/catalog.jsp";

    public LanguageCommand(String language) {
        this.language = language;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        String language = request.getParameter("language");
        HttpSession session = request.getSession();
        session.setAttribute("language", language);
        return CommandResult.forward(CURRENT_PAGE);
    }
}
