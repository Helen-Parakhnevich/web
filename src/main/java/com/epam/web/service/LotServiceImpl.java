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
import java.util.Optional;

public class LotServiceImpl implements LotService {

    private DaoHelperFactory daoHelperFactory;

    private final Logger LOGGER = LogManager.getLogger(Controller.class);

    public LotServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public List<Lot> getCurrentByType(LotType type) throws ServiceException {

        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            LotDao lotDao = daoHelper.createLotDao();
            List<Lot> directLot= lotDao.getCurrentByType(type);
            return directLot;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Lot> getDirectByCategory(long id) throws ServiceException {

        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            LotDao lotDao = daoHelper.createLotDao();
            List<Lot> directLot= lotDao.getDirectByCategory(id);
            return directLot;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Lot> getById(long id) throws ServiceException {
        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            LotDao lotDao = daoHelper.createLotDao();
            Optional<Lot> lot = lotDao.getById(id);
            return lot;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Lot> getByIdWithBid(long id) throws ServiceException {
        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            LotDao lotDao = daoHelper.createLotDao();
            Optional<Lot> lot = lotDao.getByIdWithBid(id);
            return lot;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }
}
