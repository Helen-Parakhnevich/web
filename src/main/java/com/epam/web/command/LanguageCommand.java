package com.epam.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

public class LanguageCommand implements Command {

    private static final String MAIN_PAGE = "jsp/catalog.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        String[] language_country = request.getParameter("language").split("_");
        String currentPage = request.getHeader("referer");
        String language = language_country[0];
        String country = language_country[1];
        Locale locale = new Locale(language, country);
        HttpSession session = request.getSession();
        session.setAttribute("locale", locale);
        session.setAttribute("language", language);
        return CommandResult.redirect(currentPage);
    }
}
