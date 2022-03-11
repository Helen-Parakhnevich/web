package com.epam.web.dao;

import com.epam.web.entity.Lot;
import com.epam.web.entity.LotType;
import com.epam.web.exception.DaoException;

import java.util.List;

public interface LotDao {

    List<Lot> getCurrentByType(LotType type) throws DaoException;
}
