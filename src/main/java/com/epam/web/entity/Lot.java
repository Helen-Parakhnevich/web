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
    public static final String IMAGE = "img";

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

    public Lot(Long id, Long categoryId, LotType type, String title) {
        this.id = id;
        this.type = type;
        this.categoryId = categoryId;
        this.title = title;
    }
}
