package com.epam.web.dao;

import com.epam.web.entity.Identifiable;
import com.epam.web.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface Dao<T extends Identifiable> {

    public Optional<T> getById(long id) throws DaoException;
    public List<T> getAll() throws DaoException;
    public boolean create(T object) throws DaoException;
    public void save(T object) throws DaoException;
    public Optional<T> removeById(Long id)  throws DaoException;

}
