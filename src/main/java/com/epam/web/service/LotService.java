package com.epam.web.service;

import com.epam.web.entity.Lot;
import com.epam.web.exception.ServiceException;

import java.util.List;

public interface LotService {

    List<Lot> getAllDirect() throws ServiceException;

}
