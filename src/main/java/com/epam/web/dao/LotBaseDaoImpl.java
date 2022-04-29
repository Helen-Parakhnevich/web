package com.epam.web.dao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.entity.Lot;
import com.epam.web.entity.LotBase;
import com.epam.web.entity.LotType;
import com.epam.web.exception.DaoException;
import com.epam.web.mapper.LotBaseRowMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LotBaseDaoImpl extends AbstractDao<LotBase> implements LotBaseDao {

    public static final String TABLE = "lot_base";

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

    private static final String CREATE_LOT = "INSERT INTO lot (category_id, type, title, start_price, date_start, date_end, user_id)" +
            " values(?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_REQUEST_LOT = "SELECT lot.*, CONCAT(user.first_name, ' ', user.last_name) as seller  FROM lot " +
            "LEFT JOIN user on lot.user_id=user.id WHERE lot.is_deleted='0' AND lot.status='NEW'";
    private static final String APPROVE_LOT = "UPDATE lot SET status='CURRENT' WHERE lot.id = ?";
    private static final String UPDATE_LOT_BY_ID = "UPDATE lot set category_id=?, type=?, title=?, start_price=?, date_start=?, date_end=? "
            + "where lot.id=?";
    private static final String PAY_LOT = "UPDATE lot SET status='SOLD', is_paid='1' WHERE lot.id = ?";

    public LotBaseDaoImpl(ProxyConnection connection) {
        super(connection, new LotBaseRowMapper(), TABLE);
    }

    @Override
    public boolean create(LotBase lot) throws DaoException {
        LotType type = lot.getType();
        Long categoryId = lot.getCategoryId();
        String title = lot.getTitle();
        LocalDateTime dateStart = lot.getDateStart();
        LocalDateTime dateEnd = lot.getDateStart();
        BigDecimal startPrice = lot.getStartPrice();
        Long userId = lot.getUserId();
        executeQueryNoResult(CREATE_LOT, categoryId, type.getTitle(), title, startPrice, dateStart, dateEnd, userId);
        return true;
    }

    @Override
    public List<LotBase> getRequestLot() throws DaoException {
        return executeQuery(GET_REQUEST_LOT, new LotBaseRowMapper());
    }

    @Override
    public boolean approveLot(Long id) throws DaoException{
        executeQueryNoResult(APPROVE_LOT, id);
        return true;
    }

    @Override
    public boolean updateLot(LotBase lot) throws DaoException {
        executeQueryNoResult(UPDATE_LOT_BY_ID, lot.getCategoryId(), lot.getType().getTitle(), lot.getTitle(), lot.getStartPrice(),
                              lot.getDateStart(), lot.getDateEnd(), lot.getId());
        return true;
    }

    @Override
    public boolean payLot(Long id) throws DaoException {
        executeQueryNoResult(PAY_LOT, id);
        return true;
    }

    @Override
    public Optional<LotBase> removeById(Long id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    protected Map<String, Object> getFields(LotBase item) {
        return null;
    }

    @Override
    protected String getTableName() {
        return Lot.TABLE;
    }

    @Override
    protected String getRowMapperTableName() {
        return LotBase.TABLE;
    }

}
