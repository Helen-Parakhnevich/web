package com.epam.web.mapper;

import com.epam.web.entity.Bid;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class BidRowMapper implements RowMapper {

    @Override
    public Bid map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(Bid.ID);
        Long lotId = resultSet.getLong(Bid.LOT_ID);
        Long userId = resultSet.getLong(Bid.USER_ID);
        Timestamp date = resultSet.getTimestamp(Bid.DATE);
        BigDecimal sum = resultSet.getBigDecimal(Bid.SUM_BID);

        Bid bid = new Bid(id, lotId, userId, date, sum);
        return bid;
    }
}
