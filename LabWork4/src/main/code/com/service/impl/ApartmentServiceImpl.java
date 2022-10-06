package main.code.com.service.impl;

import main.code.com.dao.DaoFactory;
import main.code.com.dao.description.ApartamentDao;
import main.code.com.dao.description.UserOrderDao;
import main.code.com.dao.impl.ApartamentDaoImpl;
import main.code.com.dao.impl.UserOrderDaoImpl;
import main.code.com.entity.Apartment;
import main.code.com.entity.UserOrder;
import main.code.com.exeptions.DaoException;
import main.code.com.exeptions.ServiceException;
import main.code.com.service.description.ApartmentService;
import main.code.com.service.validator.Validator;
import main.code.com.service.validator.ValidatorFactory;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ApartmentServiceImpl implements ApartmentService {
    @Override
    public List<Apartment> retrieveApartamentByType(String type) throws ServiceException {
        try {
            ApartamentDao apartamentDao= DaoFactory.getInstance().getApartamentDao();

            List<Apartment> result = null;
            result = apartamentDao.findByType(type);
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    @Override
    public List<Apartment> retrieveApartamentByStatus(String status) throws ServiceException {
        try {
            ApartamentDao apartamentDao= DaoFactory.getInstance().getApartamentDao();

            List<Apartment> result = null;
            result = apartamentDao.findByStatus(status);
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    public List<Apartment> retrieveApartamentsByUserOrders(List<UserOrder> userOrders) throws ServiceException {
        try {
            ApartamentDao apartamentDao= DaoFactory.getInstance().getApartamentDao();

            List<Apartment> result = new ArrayList<>();
            for (UserOrder userOrder : userOrders) {
                result.add(apartamentDao.findById(userOrder.getApartmentId()).get());
            }
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Apartment> retrieveApartamentById(int apartament) throws ServiceException {

        try {
            ApartamentDao apartamentDao= DaoFactory.getInstance().getApartamentDao();
            Optional<Apartment> result;
            result = apartamentDao.findById(apartament);
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Apartment> retrieveApartamentsByUserId(int userId) throws ServiceException {
        try {
            UserOrderDao userOrderDao=DaoFactory.getInstance().getUserOrderDao();
            List<UserOrder> userOrders=userOrderDao.findByUserId(userId);
            List<Apartment> result=new ArrayList<>();
            ApartamentDao apartamentDao= DaoFactory.getInstance().getApartamentDao();
            for (UserOrder userOrder : userOrders) {
                result.add(apartamentDao.findById(userOrder.getApartmentId()).get());
            }
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Apartment> retrieveALLApartaments() throws ServiceException {
        try {
            ApartamentDao apartamentDao= DaoFactory.getInstance().getApartamentDao();
            List<Apartment> result;
            result = apartamentDao.findAll();
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void removeApartmentById(int apartmentId) throws ServiceException {
        try {
            ApartamentDao apartamentDao= DaoFactory.getInstance().getApartamentDao();
            UserOrderDaoImpl userOrderDao=DaoFactory.getInstance().getUserOrderDao();

            List<UserOrder> userOrders=userOrderDao.findByApartmentID(apartmentId);
            for (UserOrder userOrder : userOrders) {
                userOrderDao.removeById(userOrder.getId());
            }
            apartamentDao.removeById(apartmentId);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean addNewApartment(String status, String type, String StringNumberOfRooms,
                                   String StringApartmentNumber, String StringNumberOfBeds, String StringPrice,String photo) throws ServiceException {

        if(status==null || type==null || StringNumberOfBeds ==null ||
                StringApartmentNumber ==null || StringNumberOfRooms ==null || StringPrice ==null || photo==null){
            return false;
        }
        Validator priceValidator= ValidatorFactory.getInstance().getPriceValidator();
        Validator naturalNumberValidator=ValidatorFactory.getInstance().getNaturalNumberValidator();

        if(!(priceValidator.isValid(StringPrice) && naturalNumberValidator.isValid(StringNumberOfBeds)
                && naturalNumberValidator.isValid(StringNumberOfRooms))){
            return false;
        }

        int numberOfBeds=Integer.parseInt(StringNumberOfBeds);
        int numberOfRooms=Integer.parseInt(StringNumberOfRooms);
        int apartamentNumber=Integer.parseInt(StringApartmentNumber);
        double price=Double.parseDouble(StringPrice);

        ApartamentDao apartamentDao=new ApartamentDaoImpl();
        Apartment apartment=buildApartment(status,type,numberOfRooms,apartamentNumber,numberOfBeds,price,photo);
        try {
            apartamentDao.save(apartment);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean updateApartmentInformation(String StringId, String status, String type, String StringNumberOfRooms,
                                              String StringApartmentNumber, String StringNumberOfBeds, String StringPrice,String photo) throws ServiceException {
        if(status==null || type==null || StringNumberOfBeds ==null ||
                StringApartmentNumber ==null || StringNumberOfRooms ==null || StringPrice ==null || photo==null){
            return false;
        }
        Validator priceValidator= ValidatorFactory.getInstance().getPriceValidator();
        Validator naturalNumberValidator=ValidatorFactory.getInstance().getNaturalNumberValidator();
        Validator idValidator=ValidatorFactory.getInstance().getIdValidator();
        Validator statusValidator=ValidatorFactory.getInstance().getStatusValidator();

        if(!(priceValidator.isValid(StringPrice) && naturalNumberValidator.isValid(StringNumberOfBeds)
                && naturalNumberValidator.isValid(StringNumberOfRooms) && idValidator.isValid(StringId)) && statusValidator.isValid(status)){
            return false;
        }

        int id=Integer.parseInt(StringId);
        int numberOfBeds=Integer.parseInt(StringNumberOfBeds);
        int numberOfRooms=Integer.parseInt(StringNumberOfRooms);
        int apartamentNumber=Integer.parseInt(StringApartmentNumber);
        double price=Double.parseDouble(StringPrice);

        ApartamentDao apartamentDao=new ApartamentDaoImpl();
        Apartment apartment=buildApartment(status,type,numberOfRooms,apartamentNumber,numberOfBeds,price,photo);
        try {
            apartamentDao.updateApartmentById(id,apartment);
            return true;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void updateApartmentStatusById(int id,String status) throws ServiceException {
        ApartamentDao apartamentDao=DaoFactory.getInstance().getApartamentDao();
        try {
            apartamentDao.updateApartmentStatusById(id,status);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    private Apartment buildApartment(String status, String type, int numberOfRooms,
                                     int apartmentNumber, int numberOfBeds, double  price, String photo){
        Apartment apartment=new Apartment();
        apartment.setStatus(status);
        apartment.setType(type);
        apartment.setNumberOfRooms(numberOfRooms);
        apartment.setApartmentNumber(apartmentNumber);
        apartment.setNumberOfBeds(numberOfBeds);
        apartment.setPrice(price);
        apartment.setPhoto(photo);
        return apartment;
    }


}
