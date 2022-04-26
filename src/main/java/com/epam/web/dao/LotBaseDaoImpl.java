package com.epam.web.dao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.entity.Lot;
import com.epam.web.entity.LotBase;
import com.epam.web.entity.LotType;
import com.epam.web.exception.DaoException;
import com.epam.web.mapper.LotBaseRowMapper;
import com.epam.web.mapper.RowMapper;

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
        //String description = lot.getDescription();
        executeQueryNoResult(CREATE_LOT, categoryId, type.getTitle(), title, startPrice, dateStart, dateEnd, userId);
        return true;
    }

    @Override
    public List<LotBase> getAll() throws DaoException {
        return super.getAll();
    }

    @Override
    public boolean save(LotBase item) throws DaoException {
        return super.save(item);
    }

    @Override
    public Optional<LotBase> executeForSingleResult(String query, RowMapper<LotBase> mapper, Object... params) throws DaoException {
        return super.executeForSingleResult(query, mapper, params);
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

    @Override
    public Optional<LotBase> getById(long id) throws DaoException {
        return super.getById(id);
    }
}
