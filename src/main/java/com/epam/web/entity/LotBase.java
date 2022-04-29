package com.epam.web.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.Objects;

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
    public static final String SELLER = "seller";

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
    private String seller;
    private Blob img;
    private String imgBase64;

    public LotBase(Long id, Long userId, Long categoryId, LotType type, String title) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.categoryId = categoryId;
        this.title = title;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LotBase)) return false;
        LotBase lotBase = (LotBase) o;
        return Objects.equals(id, lotBase.id)
                && type == lotBase.type
                && Objects.equals(categoryId, lotBase.categoryId)
                && Objects.equals(dateStart, lotBase.dateStart)
                && Objects.equals(dateEnd, lotBase.dateEnd)
                && Objects.equals(duration, lotBase.duration)
                && Objects.equals(startPrice, lotBase.startPrice)
                && Objects.equals(userId, lotBase.userId)
                && Objects.equals(isPaid, lotBase.isPaid)
                && Objects.equals(title, lotBase.title)
                && Objects.equals(seller, lotBase.seller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, categoryId, dateStart, dateEnd, duration, startPrice, status, userId, isPaid, title, seller);
    }

    @Override
    public String toString() {
        return "LotBase{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", duration=" + duration +
                ", startPrice=" + startPrice +
                ", userId=" + userId +
                ", isPaid=" + isPaid +
                '}';
    }
}
