package com.epam.web.service;

import com.epam.web.Controller;
import com.epam.web.dao.DaoHelper;
import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.dao.LotDao;
import com.epam.web.entity.Lot;
import com.epam.web.entity.LotType;
import com.epam.web.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class LotServiceImpl implements LotService {

    private DaoHelperFactory daoHelperFactory;

    private final Logger LOGGER = LogManager.getLogger(Controller.class);

    public LotServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public List<Lot> getAllDirect() throws ServiceException {

        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            LotDao lotDao = daoHelper.createLotDao();
            List<Lot> directLot= lotDao.getCurrentByType(LotType.DIRECT);
            return directLot;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }
}
