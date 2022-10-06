package main.code.com.dao.description;

import main.code.com.dao.Dao;
import main.code.com.entity.Apartment;
import main.code.com.exeptions.DaoException;

import java.util.List;

public interface ApartamentDao extends Dao<Apartment> {

    List<Apartment> findByStatus(String status) throws DaoException;

    List<Apartment> findByType(String type) throws DaoException;

    List<Apartment> findByPrice(double from,double to) throws DaoException;

    List<Apartment> findByNumberOfRooms(int number) throws DaoException;

    List<Apartment> findByNumberOfBeds(int number) throws DaoException;

    void updateApartmentById(int id,Apartment apartment) throws DaoException;

    void updateApartmentStatusById(int id,String status) throws DaoException;

}
