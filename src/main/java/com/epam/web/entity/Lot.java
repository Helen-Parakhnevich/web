package com.epam.web.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Blob;
import java.time.LocalDateTime;

@Getter
@Setter
public class Lot extends Entity {

    public static final String TABLE = "lot";

    public static final String ID = "id";
    public static final String CATEGORY_ID = "category_id";
    public static final String TYPE = "type";
    public static final String DATE_START = "date_start";
    public static final String DATE_END = "date_end";
    public static final String DURATION = "duration";
    public static final String START_PRICE = "start_price";
    public static final String STATUS = "status";
    public static final String USER_ID = "user_id";
    public static final String IS_PAID = "is_paid";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String IMAGE = "img";
    public static final String SELLER = "seller";
    public static final String BID_ID = "bid_id";
    public static final String BID_SUM = "bid_sum";
    public static final String BID_USER_ID = "bid_user_id";
    public static final String BID_USER_FIRST_NAME = "bid_user_first_name";
    public static final String BID_USER_LAST_NAME = "bid_user_last_name";


    private Long id;
    private LotType type;
    private Long categoryId;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private String stringDateEnd;
    private Integer duration;
    private BigDecimal startPrice;
    private Long userId;
    private Boolean isPaid;
    private String title;
    private String description;
    private Blob img;
    private String seller;
    private String imgBase64;
    private Long bidId;
    private BigDecimal bidSum;
    private Long bidUserId;
    private String bidUserFirstName;
    private String bidUserLastName;

    public Lot(Long id, Long categoryId, LotType type, String title) {
        this.id = id;
        this.type = type;
        this.categoryId = categoryId;
        this.title = title;
    }
}
