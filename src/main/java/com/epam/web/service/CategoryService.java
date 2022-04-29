package com.epam.web.service;

import com.epam.web.entity.Category;
import com.epam.web.exception.ServiceException;

import java.util.Optional;

public interface CategoryService {

    Optional<Category> getById(Long id) throws ServiceException;

}

