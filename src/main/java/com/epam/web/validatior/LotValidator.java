package com.epam.web.validatior;

import com.epam.web.dao.DaoHelperFactory;
import com.epam.web.entity.Category;
import com.epam.web.entity.LotBase;
import com.epam.web.entity.User;
import com.epam.web.exception.ServiceException;
import com.epam.web.service.CategoryServiceImpl;
import com.epam.web.service.UserServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class LotValidator {

    private static final String LOCAL_DATE_TIME_PATTERN = "^(\\d{4,})-(\\d{2})-(\\d{2})[T ](\\d{2}):(\\d{2})(?::(\\d{2}(?:\\.\\d+)?))?$";
    private static final String PRICE_PATTERN = "\\d{1,10}+(?:,\\d{1,2})|\\d{1,10}";

    private final DaoHelperFactory daoHelperFactory = new DaoHelperFactory();

    public boolean isDataLotValid(LotBase lot) throws ServiceException {
        Long userId = lot.getUserId();
        Long categoryId = lot.getCategoryId();
        LocalDateTime dateStart = lot.getDateStart();
        LocalDateTime dateEnd = lot.getDateEnd();
        BigDecimal price = lot.getStartPrice();

        return (isUserValid(userId)
                && isCategoryValid(categoryId)
                && isPriceValid(price)
                && isDateValid(dateStart)
                && isDateValid(dateEnd)
                && dateEnd.isAfter(dateStart));

    }

    private boolean isDateValid(LocalDateTime date) {
        return date.toString().matches(LOCAL_DATE_TIME_PATTERN);
    }

    private boolean isCategoryValid(Long id) throws ServiceException {

        CategoryServiceImpl categoryService = new CategoryServiceImpl(daoHelperFactory);
        Optional<Category> category = categoryService.getById(id);
        if (category.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isUserValid(Long id) throws ServiceException {

        UserServiceImpl userService = new UserServiceImpl(daoHelperFactory);
        Optional<User> user = userService.getById(id);
        if (user.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isPriceValid(BigDecimal price) throws ServiceException {
        return price.toString().matches(PRICE_PATTERN);
    }
}
