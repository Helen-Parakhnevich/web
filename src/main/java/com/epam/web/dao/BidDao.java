package com.epam.web.dao;

import com.epam.web.entity.Bid;
import com.epam.web.exception.DaoException;

public interface BidDao {

    boolean create(Bid bid) throws DaoException;

}
