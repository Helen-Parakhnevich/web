package com.epam.web.service;

import com.epam.web.dao.BidDao;
import com.epam.web.dao.DaoHelper;
import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.entity.Bid;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BidServiceImpl implements BidService {

    private DaoHelperFactory daoHelperFactory;

    private final Logger LOGGER = LogManager.getLogger(BidServiceImpl.class);

    public BidServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public boolean create(Bid bid) throws ServiceException {
        try (DaoHelper daoHelper = daoHelperFactory.create()) {
            daoHelper.startTransaction();
            BidDao bidDao = daoHelper.createBidDao();
            bidDao.create(bid);
            daoHelper.endTransaction();
            return true;
        } catch (DaoException e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException("Can't store bid", e);
        }
    }




}
