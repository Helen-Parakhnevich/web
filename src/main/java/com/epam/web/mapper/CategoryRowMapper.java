package com.epam.web.mapper;

import com.epam.web.entity.Category;
import com.epam.web.entity.Identifiable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper {

    @Override
    public Identifiable map(ResultSet resultSet) throws SQLException {

        Long id = resultSet.getLong(Category.ID);
        String name = resultSet.getString(Category.NAME);
        String en = resultSet.getString(Category.EN);
        String be = resultSet.getString(Category.BE);
        String ru = resultSet.getString(Category.RU);

        return new Category(id, name, en, be, ru);

    }
}
