package com.epam.web.dao;

import com.epam.web.entity.Category;
import com.epam.web.exception.DaoException;

import java.util.List;

public interface CategoryDao {
    List<Category> getAll() throws DaoException;
}
