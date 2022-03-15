package com.epam.web.command;

import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.LotServiceImpl;
import com.epam.web.service.UserServiceImpl;

public class CommandFactory {

    private final DaoHelperFactory daoHelperFactory = new DaoHelperFactory();

    public Command create(String command) throws ServiceException {
        switch (command) {
            case "login":
                return new LoginCommand(new UserServiceImpl(daoHelperFactory));
            case "logout":
                return new LogoutCommand();
            case "direct_lot_by_category":
                return new DirectLotByCategory(new LotServiceImpl(daoHelperFactory));
            case "reverse_lot":
                return new ReversLot(new LotServiceImpl(daoHelperFactory));
            case "show_lot":
                return new ShowLotCommand(new LotServiceImpl(daoHelperFactory));
            case "some_page":
                return new ShowPageCommand("some_page");
            case "en":
            case "ru":
            case "by":
                return new LanguageCommand(command);
            default:
                throw new IllegalArgumentException("Unknown command = " + command);
        }
    }

}
