package com.epam.web.mapper;

import com.epam.web.entity.Lot;
import com.epam.web.entity.LotBase;
import com.epam.web.entity.LotStatus;
import com.epam.web.entity.LotType;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Base64;

public class LotBaseRowMapper implements RowMapper {

    @Override
    public LotBase map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(Lot.ID);
        Long categoryId = resultSet.getLong(Lot.CATEGORY_ID);
        LotType type = LotType.geTypeByTitle(resultSet.getString(Lot.TYPE));
        Timestamp dateStart = resultSet.getTimestamp(Lot.DATE_START);
        Timestamp dateEnd = resultSet.getTimestamp(Lot.DATE_END);
        BigDecimal startPrice = resultSet.getBigDecimal(Lot.START_PRICE);
        LotStatus status = LotStatus.geStatusByTitle(resultSet.getString(Lot.STATUS));
        Long userId = resultSet.getLong(Lot.USER_ID);
        Boolean isPaid = resultSet.getBoolean(Lot.IS_PAID);
        String title = resultSet.getString(Lot.TITLE);
        //String description = resultSet.getString(Lot.DESCRIPTION);
        Blob imageData = resultSet.getBlob(Lot.IMAGE);

        String pattern = "yyyy-MM-dd'T'HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String stringDateEnd = simpleDateFormat.format(dateEnd);

        LotBase lot = new LotBase(id, categoryId, type, title);
        lot.setDateStart(dateStart);
        lot.setDateEnd(dateEnd);
        lot.setStringDateEnd(stringDateEnd);
        lot.setStartPrice(startPrice);
        lot.setStatus(status);
        lot.setUserId(userId);
        lot.setIsPaid(isPaid);
        if (imageData!=null) {
            lot.setImg(imageData);
            lot.setImgBase64(Base64.getEncoder().encodeToString(imageData.getBytes(1, (int) imageData.length())));
        }
        //lot.setDescription(description);

        return lot;
    }
}
