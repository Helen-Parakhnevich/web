package com.epam.web.service;

import com.epam.web.dao.CategoryDao;
import com.epam.web.dao.DaoHelper;
import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.entity.Category;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl implements CategoryService {

    private DaoHelperFactory daoHelperFactory;

    private final Logger LOGGER = LogManager.getLogger(CategoryServiceImpl.class);

    public CategoryServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<Category> getAll() throws ServiceException {

        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            CategoryDao categoryDao = daoHelper.createCategoryDao();
            List<Category> categories= categoryDao.getAll();
            return categories;
        } catch (DaoException e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Category> getById(Long id) throws ServiceException {
        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            CategoryDao categoryDao = daoHelper.createCategoryDao();
            Optional<Category> category= categoryDao.getById(id);
            return category;
        } catch (DaoException e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

}
