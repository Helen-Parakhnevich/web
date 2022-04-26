package com.epam.web.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Blob;
import java.time.LocalDateTime;

@Getter
@Setter
public class LotBase extends Entity {

    public static final String TABLE = "lot_base";

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


    private Long id;
    private LotType type;
    private Long categoryId;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private String stringDateEnd;
    private Integer duration;
    private BigDecimal startPrice;
    private LotStatus status;
    private Long userId;
    private Boolean isPaid;
    private String title;
    private String description;
    private Blob img;
    private String imgBase64;

    public LotBase(Long id, Long userId, Long categoryId, LotType type, String title) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.categoryId = categoryId;
        this.title = title;
    }

//    public LotBase(long id, LotType type, Long categoryId, String title, BigDecimal startPrice, Timestamp dateStart, Timestamp dateEnd) {
//        this.id = id;
//        this.type = type;
//        this.categoryId = categoryId;
//        this.dateStart = dateStart;
//        this.dateEnd = dateEnd;
//        this.startPrice = startPrice;
//        this.title = title;
//    }

    public LotBase(long id, Long categoryId, LotType type, String title, BigDecimal startPrice, LocalDateTime dateStart, LocalDateTime dateEnd, Long userId) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.categoryId = categoryId;
        this.startPrice = startPrice;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.title = title;
    }
}
