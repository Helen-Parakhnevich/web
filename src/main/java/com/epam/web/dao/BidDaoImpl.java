package com.epam.web.dao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.entity.Bid;
import com.epam.web.exception.DaoException;
import com.epam.web.mapper.BidRowMapper;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Map;
import java.util.Optional;

public class BidDaoImpl extends AbstractDao<Bid> implements BidDao {

    public static final String TABLE = "bid";

    private static final String CREATE_BID = "insert into bid (lot_id, user_id, date, sum_bid)" +
            " values(?, ?, ?, ?)";

    public BidDaoImpl(ProxyConnection connection) {
        super(connection, new BidRowMapper(), TABLE);
    }

    @Override
    public boolean create(Bid bid) throws DaoException {

        Long lotId = bid.getLotId();
        Long userId = bid.getUserId();
        Timestamp date = bid.getDateBid();
        BigDecimal sum = bid.getSumBid();

        executeQueryNoResult(CREATE_BID, lotId, userId, date, sum);

        return true;
    }

    @Override
    public Optional<Bid> removeById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    protected Map<String, Object> getFields(Bid item) {
        return null;
    }

    @Override
    protected String getTableName() {
        return null;
    }
}
