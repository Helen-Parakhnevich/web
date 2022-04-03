package com.epam.web.dao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.entity.Category;
import com.epam.web.exception.DaoException;
import com.epam.web.mapper.RowMapper;
import com.epam.web.mapper.UserRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CategoryDaoImpl extends AbstractDao<Category> implements CategoryDao {

    public static final String TABLE = "category";

    public static final String ID = "id";
    public static final String NAME = "name";

    public CategoryDaoImpl(ProxyConnection connection) {
        super(connection, new UserRowMapper(), TABLE);
    }

    @Override
    public List<Category> getAll() throws DaoException {
        return super.getAll();
    }

    @Override
    public void save(Category item) throws DaoException {
        super.save(item);
    }

    @Override
    public Optional<Category> executeForSingleResult(String query, RowMapper<Category> mapper, Object... params) throws DaoException {
        return super.executeForSingleResult(query, mapper, params);
    }

    @Override
    public Optional<Category> getById(long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public boolean create(Category category) throws DaoException {
        return false;
    }

    @Override
    public Optional<Category> removeById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    protected Map<String, Object> getFields(Category item) {
        Map<String, Object> fields = new HashMap<>();
        fields.put(Category.ID, item.getId());
        fields.put(Category.NAME, item.getName());
        return fields;
    }

    @Override
    protected String getTableName() {
        return Category.TABLE;
    }
}
