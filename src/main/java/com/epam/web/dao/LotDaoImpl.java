package com.epam.web.dao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.entity.Category;
import com.epam.web.entity.Lot;
import com.epam.web.entity.LotStatus;
import com.epam.web.entity.LotType;
import com.epam.web.exception.DaoException;
import com.epam.web.mapper.LotRowMapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LotDaoImpl extends AbstractDao<Lot> implements LotDao {

    public static final String TABLE = "lot";

    public static final String ID = "id";
    public static final String CATEGORY_ID = "category_id";
    public static final String TYPE = "type";
    public static final String DATE_START = "date_start";
    public static final String DATE_END = "date_end";
    public static final String DURATION = "date_end";
    public static final String START_PRICE = "start_price";
    public static final String STATUS = "status";
    public static final String USER_ID = "user_id";
    public static final String IS_PAID = "is_paid";

    private static final String GET_LOT_WITH_MAX_BID_PART_1 = "WITH lot_max_bid AS ( " +
            "SELECT " +
            "lots.id as lot_id," +
            "lots.title AS title," +
            "lots.date_start AS date_start," +
            "lots.date_end AS date_end," +
            "lots.type AS type," +
            "lots.category_id AS category_id," +
            "lots.start_price AS start_price," +
            "lots.status AS status," +
            "lots.user_id AS user_id," +
            "lots.is_paid AS is_paid," +
            "lots.img AS img," +
            "MAX(sum_bid) AS sum_bid " +
            "FROM auction.lot AS lots " +
            "LEFT JOIN " +
            "auction.bid AS bids " +
            "ON bids.lot_id = lots.id ";

    private static final String GET_LOT_WITH_MAX_BID_PART_2 = " GROUP BY lots.id) " +
            "SELECT " +
            "lot_max_bid.lot_id AS id," +
            "lot_max_bid.title AS title," +
            "lot_max_bid.date_start AS date_start," +
            "lot_max_bid.date_end AS date_end," +
            "lot_max_bid.type AS type," +
            "lot_max_bid.category_id AS category_id," +
            "lot_max_bid.start_price AS start_price," +
            "lot_max_bid.status AS status," +
            "lot_max_bid.user_id AS user_id," +
            "lot_max_bid.is_paid AS is_paid," +
            "lot_max_bid.img AS img," +
            "lot_max_bid.sum_bid AS bid_sum," +
            "'' as seller," +
            "bids.id AS bid_id," +
            "bids.user_id AS bid_user_id," +
            "users.first_name AS bid_user_first_name," +
            "users.last_name AS bid_user_last_name " +
            "FROM lot_max_bid " +
            "LEFT JOIN auction.bid as bids " +
            "ON lot_max_bid.sum_bid = bids.sum_bid AND lot_max_bid.lot_id=bids.lot_id " +
            "LEFT JOIN auction.user AS users " +
            "ON users.id=bids.user_id" ;

    private static final String CONDITION_BY_ID = "WHERE lots.id =?";
    private static final String CONDITION_NOT_DELETED = "WHERE lots.is_deleted='0'";
    private static final String CONDITION_AND_NOT_DELETED = " AND lots.is_deleted='0'";
    private static final String CONDITION_BY_TYPE_BY_STATUS_BY_CATEGORY = "WHERE lots.date_start <= curdate() " +
                                "AND lots.date_end >= curdate() AND lots.type = ? AND lots.status = ?  AND category_id = ?";
    private static final String CONDITION_BY_TYPE_BY_STATUS = "WHERE lots.date_start <= curdate() " +
                                "AND lots.date_end >= curdate() AND lots.type = ? AND lots.status = ?";
    private static final String CONDITION_ENDED_UNPAID_BY_TYPE = "WHERE lots.date_end <= curdate() AND lots.is_paid='0'" +
                                "AND lots.type = ? AND lots.status = 'current'";
    private static final String CONDITION_BY_USER = " WHERE users.id =?";

    private static final String GET_LOT_BY_ID_WITH_BID =
                                GET_LOT_WITH_MAX_BID_PART_1 + CONDITION_BY_ID + GET_LOT_WITH_MAX_BID_PART_2;

    private static final String GET_CURRENT_WITH_MAX_BID_LOT_BY_TYPE_BY_STATUS_BY_CATEGORY = GET_LOT_WITH_MAX_BID_PART_1 +
                                CONDITION_BY_TYPE_BY_STATUS_BY_CATEGORY + CONDITION_AND_NOT_DELETED + GET_LOT_WITH_MAX_BID_PART_2;

    private static final String GET_CURRENT_WITH_MAX_BID_LOT_BY_TYPE_BY_STATUS = GET_LOT_WITH_MAX_BID_PART_1 +
                                CONDITION_BY_TYPE_BY_STATUS + CONDITION_AND_NOT_DELETED + GET_LOT_WITH_MAX_BID_PART_2;

    private static final String GET_ENDED_BY_WIN_USER_ID =  GET_LOT_WITH_MAX_BID_PART_1 +
                                CONDITION_ENDED_UNPAID_BY_TYPE + GET_LOT_WITH_MAX_BID_PART_2 + CONDITION_BY_USER;

    public LotDaoImpl(ProxyConnection connection) {
        super(connection, new LotRowMapper(), TABLE);
    }

    @Override
    public Optional<Lot> getByIdWithBid(Long id) throws DaoException {
        return executeForSingleResult(GET_LOT_BY_ID_WITH_BID, new LotRowMapper(), id);
    }

    @Override
    public List<Lot> getCurrentByType(LotType type) throws DaoException {
        return executeQuery(GET_CURRENT_WITH_MAX_BID_LOT_BY_TYPE_BY_STATUS, new LotRowMapper(), type.getTitle(), LotStatus.CURRENT.getTitle());
    }

    @Override
    public List<Lot> getDirectByCategory(Long id) throws DaoException {
        return executeQuery(GET_CURRENT_WITH_MAX_BID_LOT_BY_TYPE_BY_STATUS_BY_CATEGORY,
                             new LotRowMapper(), LotType.DIRECT.getTitle(), LotStatus.CURRENT.getTitle(), id);
    }

    @Override
    public List<Lot> getReversByCategory(Category category) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public List<Lot> getEndedDirectUnpaid(Long userId) throws DaoException {
        return executeQuery(GET_ENDED_BY_WIN_USER_ID, new LotRowMapper(), LotType.DIRECT.getTitle(), userId);
    }

    @Override
    public boolean create(Lot object) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Optional<Lot> removeById(Long id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    protected Map<String, Object> getFields(Lot item) {
        return null;
    }

    @Override
    protected String getTableName() {
        return Lot.TABLE;
    }

    @Override
    protected String getRowMapperTableName() {
        return Lot.TABLE;
    }

}
