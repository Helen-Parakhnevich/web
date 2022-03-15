package com.epam.web.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Timestamp;

@Getter
@Setter
public class Lot extends Entity {

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
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String IMAGE = "image";
    public static final String BID_ID = "bid_id";
    public static final String BID_SUM = "bid_sum";
    public static final String BID_USER_ID = "bid_user_id";
    public static final String BID_USER_FIRST_NAME = "bid_user_first_name";
    public static final String BID_USER_LAST_NAME = "bid_user_last_name";

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private long id;

    private LotType type;
    private Long categoryId;
    private Timestamp dateStart;
    private Timestamp dateEnd;
    private String stringDateEnd;
    private BigDecimal startPrice;
    private Long userId;
    private boolean isPaid;
    private String title;
    private String description;
    private Blob img;
    private String imgBase64;
    private Long bidId;
    private BigDecimal bidSum;
    private Long bidUserId;
    private String bidUserFirstName;
    private String bidUserLastName;

    public Lot(Long id, Long categoryId, LotType type, String title) {
        super(id);
        this.type = type;
        this.categoryId = categoryId;
        this.title = title;
    }
}
