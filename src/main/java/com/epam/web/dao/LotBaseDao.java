package com.epam.web.dao;

import com.epam.web.entity.LotBase;
import com.epam.web.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface LotBaseDao {

    boolean create(LotBase lot) throws DaoException;
    Optional<LotBase> getById(Long id) throws DaoException;
    List<LotBase> getAll() throws DaoException;
}
