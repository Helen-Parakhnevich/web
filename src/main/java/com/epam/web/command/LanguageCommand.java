package com.epam.web.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LanguageCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        String local = request.getParameter("local");
        HttpSession session = request.getSession();
        session.setAttribute("local", local);
        return null;
    }
}
