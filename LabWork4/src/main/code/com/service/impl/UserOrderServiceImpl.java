package main.code.com.service.impl;

import main.code.com.dao.DaoFactory;
import main.code.com.dao.description.UserOrderDao;
import main.code.com.entity.UserOrder;
import main.code.com.exeptions.DaoException;
import main.code.com.exeptions.ServiceException;
import main.code.com.service.description.UserOrderService;
import main.code.com.service.validator.Validator;
import main.code.com.service.validator.ValidatorFactory;

import java.sql.Timestamp;
import java.util.*;

public class UserOrderServiceImpl implements UserOrderService {
    private  static final String STATUS="booked";


    @Override
    public Optional<UserOrder> retrieveUserOrderById(int userOrderId) throws ServiceException {
        try {
            UserOrderDao userOrderDao = DaoFactory.getInstance().getUserOrderDao();
            Optional<UserOrder> result;
            result = userOrderDao.findById(userOrderId);
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<UserOrder> retrieveUserOrderByUserId(int userId) throws ServiceException {
        try {
            UserOrderDao userOrderDao = DaoFactory.getInstance().getUserOrderDao();
            List<UserOrder> result;
            result = userOrderDao.findByUserId(userId);
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<UserOrder> retrieveUserOrderByStatus(String status) throws ServiceException {
        try {
            UserOrderDao userOrderDao = DaoFactory.getInstance().getUserOrderDao();
            List<UserOrder> result = null;
            result = userOrderDao.findByStatus(status);
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }


    @Override
    public boolean updateStatusAtUserOrderById(int userOrderId, String status) throws ServiceException {
        try {
            UserOrderDao userOrderDao = DaoFactory.getInstance().getUserOrderDao();
            Optional<UserOrder> userOrder = userOrderDao.findById(userOrderId);
            if (!userOrder.isPresent()) {
                return false;
            }
            userOrderDao.updateStatusById(userOrderId, status);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean addNewUserOrder( String stringYear,String stringMonth,String stringDay,String stringHours,
                                   String stringMinutes, String stringLeaseDuration,String stringUserId,String stringApartmentId) throws ServiceException {

        if ( stringYear == null  || stringMonth==null || stringHours == null ||
                stringLeaseDuration==null || stringUserId==null || stringApartmentId==null ) {
            return false;
        }



        Validator monthValidator = ValidatorFactory.getInstance().getMonthValidator();
        Validator yearValidator = ValidatorFactory.getInstance().getYearValidator();
        Validator dayValidator=ValidatorFactory.getInstance().getDayValidator();
        Validator minuteValidator=ValidatorFactory.getInstance().getMinuteValidator();
        Validator naturalNumberValidator=ValidatorFactory.getInstance().getNaturalNumberValidator();
        Validator idValidator=ValidatorFactory.getInstance().getIdValidator();



        if (!( monthValidator.isValid(stringMonth) && yearValidator.isValid(stringYear) &&
                dayValidator.isValid(stringDay) &&  minuteValidator.isValid(stringMinutes) && naturalNumberValidator.isValid(stringLeaseDuration)
                && idValidator.isValid(stringUserId) && idValidator.isValid(stringApartmentId))) {
            return false;
        }



        int year=Integer.parseInt(stringYear);
        int month=Integer.parseInt(stringMonth);
        int day=Integer.parseInt(stringDay);
        int hours=Integer.parseInt(stringHours);
        int minutes=Integer.parseInt(stringMinutes);
        int leaseDuration=Integer.parseInt(stringLeaseDuration);
        int userId=Integer.parseInt(stringUserId);
        int apartmentId=Integer.parseInt(stringApartmentId);


        Timestamp currentDateTime=new Timestamp(System.currentTimeMillis());
        Timestamp orderDateTime=new Timestamp(year-1900,month-1,day,hours,minutes,0,0);

        if(!isDateTimeValid(currentDateTime,orderDateTime)){
            return false;
        }



        try {

            UserOrder userOrder = buildUserOrder(STATUS,orderDateTime,leaseDuration,userId,apartmentId);
            UserOrderDao userOrderDao = DaoFactory.getInstance().getUserOrderDao();
            userOrderDao.save(userOrder);
            return true;
        } catch (DaoException e) {

            throw new ServiceException(e.getMessage(), e);
        }

    }



    private boolean isDateTimeValid(Timestamp currentDateTime, Timestamp orderDateTime) {
        if(currentDateTime.compareTo(orderDateTime)>0){
            return false;
        }
        return true;
    }



    private UserOrder buildUserOrder( String status, Timestamp startTime, int leaseDuration,int userId,int apartmentId) {
        UserOrder userOrder = new UserOrder();
        userOrder.setStatus(status);
        userOrder.setStartTime(startTime);
        userOrder.setLeaseDuration(leaseDuration);
        userOrder.setUserId(userId);
        userOrder.setApartmentId(apartmentId);
        return userOrder;
    }



}
