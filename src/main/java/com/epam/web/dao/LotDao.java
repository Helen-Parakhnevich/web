package com.epam.web.dao;

import com.epam.web.entity.Category;
import com.epam.web.entity.Lot;
import com.epam.web.entity.LotType;
import com.epam.web.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface LotDao {

    Optional<Lot> getById(long id) throws DaoException;
    Optional<Lot> getByIdWithBid(long id) throws DaoException;
    List<Lot> getCurrentByType(LotType type) throws DaoException;
    List<Lot> getDirectByCategory(long id) throws DaoException;
    List<Lot> getReversByCategory(Category category) throws DaoException;
    List<Lot> getSold(Category category) throws DaoException;
}
