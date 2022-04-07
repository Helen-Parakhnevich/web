package com.epam.web.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class Bid extends Entity {

    public static final String TABLE = "bid";

    public static final String ID = "id";
    public static final String LOT_ID = "lot_id";
    public static final String USER_ID = "user_id";
    public static final String DATE = "date";
    public static final String SUM_BID = "sum_bid";

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Long id;

    private Long lotId;
    private Long userId;
    private Timestamp dateBid;
    private BigDecimal sumBid;

    public Bid(Long id, Long lotId, Long userId, Timestamp dateBid, BigDecimal sumBid) {
        this.id = id;
        this.lotId = lotId;
        this.userId = userId;
        this.dateBid = dateBid;
        this.sumBid = sumBid;
    }

}
