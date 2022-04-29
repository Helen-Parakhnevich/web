package com.epam.web.dao;

import com.epam.web.exception.DaoException;

public interface DaoFactory<Context> {

    public interface DaoCreator<Context> {
        public Dao create(Context context);
    }

    public Context getContext() throws DaoException;

    public Dao getDao(Context context, Class dtoClass) throws DaoException;
}
