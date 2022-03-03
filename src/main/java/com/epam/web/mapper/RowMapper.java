package com.epam.web.mapper;

import com.epam.web.entity.Identifiable;
import com.epam.web.entity.User;
import com.epam.web.entity.Lot;
import com.epam.web.entity.Bid;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T extends Identifiable> {

    T map(ResultSet resultSet) throws SQLException;

    static RowMapper<? extends Identifiable> create(String table) {
        switch (table){
            case User.TABLE:
                return new UserRowMapper();
            case Lot.TABLE:
            case Bid.TABLE:
            default:
                throw new IllegalArgumentException("Unknown table = " + table);
        }
    }

}
