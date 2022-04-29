package com.epam.web.service;

import com.epam.web.entity.Bid;
import com.epam.web.exception.ServiceException;

public interface BidService {

    boolean create(Bid bid) throws ServiceException;

}
