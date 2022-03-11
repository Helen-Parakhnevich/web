package com.epam.web.service;

import com.epam.web.Controller;
import com.epam.web.dao.CategoryDao;
import com.epam.web.dao.DaoHelper;
import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.entity.Category;
import com.epam.web.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private DaoHelperFactory daoHelperFactory;

    private final Logger LOGGER = LogManager.getLogger(Controller.class);

    public CategoryServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public List<Category> getAll() throws ServiceException {

        try (DaoHelper daoHelper= daoHelperFactory.create()) {
            CategoryDao categoryDao = daoHelper.createCategoryDao();
            List<Category> categories= categoryDao.getAll();
            return categories;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new ServiceException(e);
        }
    }
}
