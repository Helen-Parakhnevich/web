package com.epam.web.service;

import com.epam.web.entity.Lot;
import com.epam.web.entity.LotBase;
import com.epam.web.entity.LotType;
import com.epam.web.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface LotService {

    boolean create(LotBase lot) throws ServiceException;
    Optional<Lot> getById(long id) throws ServiceException;
    Optional<Lot> getByIdWithBid(long id) throws ServiceException;
    List<LotBase> getAll() throws ServiceException;
    boolean deleteLot(long id) throws ServiceException;
    boolean approveLot(long id)  throws ServiceException;
    boolean updateLot(LotBase lot) throws ServiceException;
    List<LotBase> getRequestLot() throws ServiceException;
    List<Lot> getCurrentByType(LotType type) throws ServiceException;
    List<Lot> getDirectByCategory(long id) throws ServiceException;

}
