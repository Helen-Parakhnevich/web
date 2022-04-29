package com.epam.web.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
public class Bid extends Entity {

    public static final String TABLE = "bid";

    public static final String ID = "id";
    public static final String LOT_ID = "lot_id";
    public static final String USER_ID = "user_id";
    public static final String DATE = "date";
    public static final String SUM_BID = "sum_bid";

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bid)) return false;
        Bid bid = (Bid) o;
        return Objects.equals(id, bid.id)
                && Objects.equals(lotId, bid.lotId)
                && Objects.equals(userId, bid.userId)
                && Objects.equals(dateBid, bid.dateBid)
                && Objects.equals(sumBid, bid.sumBid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lotId, userId, dateBid, sumBid);
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                ", lotId=" + lotId +
                ", userId=" + userId +
                ", dateBid=" + dateBid +
                ", sumBid=" + sumBid +
                '}';
    }
}
