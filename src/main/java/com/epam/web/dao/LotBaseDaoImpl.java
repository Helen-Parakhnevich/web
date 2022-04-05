package com.epam.web.dao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.entity.Lot;
import com.epam.web.entity.LotBase;
import com.epam.web.entity.LotType;
import com.epam.web.exception.DaoException;
import com.epam.web.mapper.LotBaseRowMapper;
import com.epam.web.mapper.RowMapper;

import java.math.BigDecimal;
import java.sql.Timestamp;
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

    private static final String CREATE_LOT = "insert into lot (category_id, type, title, start_price, date_start, date_end, duration, user_id)" +
            "values(?, ?, ?, ?, ?, ?, ?, ?)";

    public LotBaseDaoImpl(ProxyConnection connection) {
        super(connection, new LotBaseRowMapper(), TABLE);
    }

    @Override
    public boolean create(LotBase lot) throws DaoException {
        LotType type = lot.getType();
        Long categoryId = lot.getCategoryId();
        String title = lot.getTitle();
        Timestamp dateStart = lot.getDateStart();
        Timestamp dateEnd = lot.getDateStart();
        Integer duration = lot.getDuration();
        BigDecimal startPrice = lot.getStartPrice();
        Long userId = lot.getUserId();
        //String description = lot.getDescription();
        executeForSingleResult(CREATE_LOT, new LotBaseRowMapper(), categoryId, type, title, startPrice, dateStart, dateEnd, duration, userId);
        return true;
    }

    @Override
    public List<LotBase> getAll() throws DaoException {
        return super.getAll();
    }

    @Override
    public void save(LotBase item) throws DaoException {
        super.save(item);
    }

    @Override
    public Optional<LotBase> executeForSingleResult(String query, RowMapper<LotBase> mapper, Object... params) throws DaoException {
        return super.executeForSingleResult(query, mapper, params);
    }

    @Override
    public Optional<LotBase> getById(Long id) throws DaoException {
        return super.getById(id);
    }

    @Override
    public Optional<LotBase> removeById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    protected List<LotBase> executeQuery(String query, RowMapper<LotBase> mapper, Object... params) throws DaoException {
        return super.executeQuery(query, mapper, params);
    }

    @Override
    protected boolean executeUpdate(String query, Object... params) throws DaoException {
        return super.executeUpdate(query, params);
    }

    @Override
    protected Map<String, Object> getFields(LotBase item) {
        return null;
    }

    @Override
    String generateInsertQuery(Map<String, Object> fields) {
        return super.generateInsertQuery(fields);
    }

    @Override
    String generateUpdateQuery(Map<String, Object> fields) {
        return super.generateUpdateQuery(fields);
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
