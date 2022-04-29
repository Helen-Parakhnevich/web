package com.epam.web.service;

import com.epam.web.dao.BidDao;
import com.epam.web.dao.DaoHelper;
import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.entity.Bid;
import com.epam.web.exception.DaoException;
import com.epam.web.exception.ServiceException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import static org.mockito.Mockito.when;

public class BidServiceImplTest {

    DaoHelper daoHelper = Mockito.mock(DaoHelper.class);
    BidDao bidDao = Mockito.mock(BidDao.class);
    DaoHelperFactory daoHelperFactory = Mockito.mock(DaoHelperFactory.class);
    BidServiceImpl sut = new BidServiceImpl(daoHelperFactory);

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldStoreBid() throws ServiceException, DaoException {
        //given
        Bid newBid = new Bid(0L, 1L,1L, new Timestamp(new Date().getTime()), new BigDecimal(10));

        //when
        when(daoHelperFactory.create()).thenReturn(daoHelper);
        when(daoHelper.createBidDao()).thenReturn(bidDao);
        when(bidDao.create(newBid)).thenReturn(true);

        sut.create(newBid);

        //then
        Mockito.verify(daoHelperFactory, Mockito.times(1)).create();
        Mockito.verify(daoHelper, Mockito.times(1)).createBidDao();
        Mockito.verify(bidDao, Mockito.times(1)).create(newBid);

    }

    @Test
    public void shouldRiseServiceException() throws DaoException, ServiceException {
        //given
        Bid newBid = new Bid(0L, 1L,1L, new Timestamp(new Date().getTime()), new BigDecimal(10));

        //when
        when(daoHelperFactory.create()).thenReturn(daoHelper);
        when(daoHelper.createBidDao()).thenReturn(bidDao);
        when(bidDao.create(newBid)).thenThrow(new DaoException());

        ServiceException exception = Assert.assertThrows(
                ServiceException.class,
                () -> sut.create(newBid)
        );

        //then
        Assert.assertTrue(exception.getMessage().equals("Can't store bid"));
    }

    //


}