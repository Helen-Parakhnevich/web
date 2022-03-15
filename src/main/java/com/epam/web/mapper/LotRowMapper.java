package com.epam.web.mapper;

import com.epam.web.entity.Lot;
import com.epam.web.entity.LotStatus;
import com.epam.web.entity.LotType;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Base64;

public class LotRowMapper implements RowMapper {

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
    public static final String TITLE = "title";
    public static final String IMG = "img";

    @Override
    public Lot map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(Lot.ID);
        Long categoryId = resultSet.getLong(Lot.CATEGORY_ID);
        LotType type = LotType.geTypeByTitle(resultSet.getString(Lot.TYPE));
        Timestamp dateStart = resultSet.getTimestamp(Lot.DATE_START);
        Timestamp dateEnd = resultSet.getTimestamp(Lot.DATE_END);
        BigDecimal startPrice = resultSet.getBigDecimal(Lot.START_PRICE);
        LotStatus status = LotStatus.geStatusByTitle(resultSet.getString(Lot.STATUS));
        Long userId = resultSet.getLong(Lot.USER_ID);
        boolean isPaid = resultSet.getBoolean(Lot.IS_PAID);
        String title = resultSet.getString(Lot.TITLE);
        //String description = resultSet.getString(Lot.DESCRIPTION);
        Blob imageData = resultSet.getBlob(Lot.IMAGE);
        Long bidUserId = resultSet.getLong(Lot.BID_USER_ID);
        BigDecimal bidSum = resultSet.getBigDecimal(Lot.BID_SUM);
        String bidUserFirstName = resultSet.getString(Lot.BID_USER_FIRST_NAME);
        String bidUserLastName = resultSet.getString(Lot.BID_USER_LAST_NAME);

        String pattern = "yyyy-MM-dd'T'HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String stringDateEnd = simpleDateFormat.format(dateEnd);

        Lot lot = new Lot(id, categoryId, type, title);
        lot.setDateStart(dateStart);
        lot.setDateEnd(dateEnd);
        lot.setStringDateEnd(stringDateEnd);
        lot.setStartPrice(startPrice);
        lot.setUserId(userId);
        lot.setPaid(isPaid);
        lot.setImg(imageData);
        lot.setImgBase64(Base64.getEncoder().encodeToString(imageData.getBytes(1, (int) imageData.length())));
        lot.setBidUserId(bidUserId);
        lot.setBidSum(bidSum);
        lot.setBidUserFirstName(bidUserFirstName);
        lot.setBidUserLastName(bidUserLastName);
        //lot.setDescription(description);

        return lot;
    }
}
