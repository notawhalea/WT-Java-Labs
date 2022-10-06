package main.code.com.dao.description;

import main.code.com.dao.Dao;
import main.code.com.entity.User;
import main.code.com.exeptions.DaoException;

import java.util.Optional;

public interface UserDao extends Dao<User> {


    Optional<User> findByEmailAndPassword(String email, String password) throws DaoException;


    Optional<User> findByEmail(String email) throws DaoException;
}
