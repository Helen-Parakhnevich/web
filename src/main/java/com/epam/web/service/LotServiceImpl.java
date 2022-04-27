package com.epam.web.service;

import com.epam.web.dao.DaoHelper;
import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.dao.LotBaseDao;
import com.epam.web.dao.LotDao;
import com.epam.web.dao.LotDaoImpl;
import com.epam.web.entity.Lot;
import com.epam.web.entity.LotBase;
import com.epam.web.entity.LotType;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class LotServiceImpl implements LotService {

    private DaoHelperFactory daoHelperFactory;

    private final Logger LOGGER = LogManager.getLogger(LotServiceImpl.class);

    public LotServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public boolean create(LotBase lot) throws ServiceException {
        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            daoHelper.startTransaction();
            LotBaseDao lotDao = daoHelper.createLotBaseDao();
            daoHelper.endTransaction();
            return lotDao.create(lot);
        } catch (DaoException e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<LotBase> getAll() throws ServiceException {
        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            LotBaseDao lotDao = daoHelper.createLotBaseDao();
            List<LotBase> lots = lotDao.getAll();
            return lots;
        } catch (DaoException e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteLot(long id) throws ServiceException {
        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            daoHelper.startTransaction();
            LotBaseDao lotDao = daoHelper.createLotBaseDao();
            boolean successDelete = lotDao.delete(id);
            daoHelper.endTransaction();
            return successDelete;
        } catch (DaoException e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean approveLot(long id) throws ServiceException {
        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            daoHelper.startTransaction();
            LotBaseDao lotDao = daoHelper.createLotBaseDao();
            boolean successApprove = lotDao.approveLot(id);
            daoHelper.endTransaction();
            return successApprove;
        } catch (DaoException e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean updateLot(LotBase lot) throws ServiceException {
        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            daoHelper.startTransaction();
            LotBaseDao lotDao = daoHelper.createLotBaseDao();
            boolean successUpdate = lotDao.updateLot(lot);
            daoHelper.endTransaction();
            return successUpdate;
        } catch (DaoException e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<LotBase> getRequestLot() throws ServiceException {
        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            LotBaseDao lotDao = daoHelper.createLotBaseDao();
            List<LotBase> requestLot= lotDao.getRequestLot();
            return requestLot;
        } catch (DaoException e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Lot> getCurrentByType(LotType type) throws ServiceException {
        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            LotDao lotDao = daoHelper.createLotDao();
            List<Lot> directLot= lotDao.getCurrentByType(type);
            return directLot;
        } catch (DaoException e) {
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
        } catch (DaoException e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Lot> getById(long id) throws ServiceException {
        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            LotDao lotDao = daoHelper.createLotDao();
            Optional<Lot> lot = ((LotDaoImpl) lotDao).getById(id);
            return lot;
        } catch (DaoException e) {
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
        } catch (DaoException e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }
}
