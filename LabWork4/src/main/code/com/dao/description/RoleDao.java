package main.code.com.dao.description;

import main.code.com.dao.Dao;
import main.code.com.entity.Role;
import main.code.com.exeptions.DaoException;

import java.util.Optional;

public interface RoleDao extends Dao<Role> {


    Optional<Role> findByName(String name) throws DaoException;
}