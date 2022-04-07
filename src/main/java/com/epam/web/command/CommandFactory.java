package com.epam.web.command;

import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.BidServiceImpl;
import com.epam.web.service.LotServiceImpl;
import com.epam.web.service.UserServiceImpl;

public class CommandFactory {

    private static final String LOT_CREATE = "/jsp/lot_create.jsp";

    private final DaoHelperFactory daoHelperFactory = new DaoHelperFactory();

    public Command create(String command) throws ServiceException {
        switch (command) {
            case "login":
                return new LoginCommand(new UserServiceImpl(daoHelperFactory));
            case "logout":
                return new LogoutCommand();
            case "all_user":
                return new AllUserCommand(new UserServiceImpl(daoHelperFactory));
            case "all_lot":
                return new AllLotCommand(new LotServiceImpl(daoHelperFactory));
            case "direct_lot_by_category":
                return new DirectLotByCategory(new LotServiceImpl(daoHelperFactory));
            case "reverse_lot":
                return new ReversLot(new LotServiceImpl(daoHelperFactory));
            case "show_lot":
                return new ShowLotCommand(new LotServiceImpl(daoHelperFactory));
            case "make_bid":
                return new CreateBidCommand(new BidServiceImpl(daoHelperFactory));
            case "request_for_sale":
                return new ShowPageCommand(LOT_CREATE);
            case "language":
                return new LanguageCommand();
//            case "back":
//                return new BackCommand();
            default:
                throw new IllegalArgumentException("Unknown command = " + command);
        }
    }

}
