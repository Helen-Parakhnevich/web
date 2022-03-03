package com.epam.web.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShowPageCommand implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    public ShowPageCommand(String page) {
        CommandResult.forward(page);
    }
}
