package com.epam.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowPageCommand implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    public ShowPageCommand(String page) {
        CommandResult.forward(page);
    }
}
