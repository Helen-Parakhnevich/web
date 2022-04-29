package com.epam.web.dao;

import com.epam.web.entity.LotBase;
import com.epam.web.exception.DaoException;

import java.util.List;

public interface LotBaseDao extends Dao<LotBase> {

    List<LotBase> getRequestLot() throws DaoException;
    boolean approveLot(Long id)  throws DaoException;
    boolean updateLot(LotBase lot)  throws DaoException;
    boolean payLot(Long id)  throws DaoException;
}
