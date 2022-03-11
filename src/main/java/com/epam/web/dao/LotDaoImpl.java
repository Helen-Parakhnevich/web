package com.epam.web.dao;

import com.epam.web.entity.Lot;
import com.epam.web.entity.LotType;
import com.epam.web.exception.DaoException;
import com.epam.web.mapper.LotRowMapper;
import com.epam.web.mapper.RowMapper;

import java.sql.Connection;
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

    private static final String GET_CURRENT_LOT_BY_TYPE = "SELECT * FROM LOT WHERE date_start <= curdate() AND date_end >= curdate() " +
            "AND type = ?";

    public LotDaoImpl(Connection connection) {
        super(connection, new LotRowMapper(), TABLE);
    }

    @Override
    public List<Lot> getCurrentByType(LotType type) throws DaoException {
        return executeQuery(GET_CURRENT_LOT_BY_TYPE, new LotRowMapper(), type.getTitle());
    }

    @Override
    public List<Lot> getAll() throws DaoException {
        return super.getAll();
    }

    @Override
    public void save(Lot item) throws DaoException {
        super.save(item);
    }

    @Override
    public Optional<Lot> executeForSingleResult(String query, RowMapper<Lot> mapper, Object... params) throws DaoException {
        return super.executeForSingleResult(query, mapper, params);
    }

    @Override
    public Optional<Lot> getById(long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public Optional<Lot> create() throws DaoException {
        return Optional.empty();
    }

    @Override
    public Optional<Lot> removeById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    protected List<Lot> executeQuery(String query, RowMapper<Lot> mapper, Object... params) throws DaoException {
        return super.executeQuery(query, mapper, params);
    }

    @Override
    protected boolean executeUpdate(String query, Object... params) throws DaoException {
        return super.executeUpdate(query, params);
    }

    @Override
    protected Map<String, Object> getFields(Lot item) {
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
        return null;
    }
}
