package main.code.com.dao.description;

import main.code.com.dao.Dao;
import main.code.com.entity.UserInformation;
import main.code.com.exeptions.DaoException;


public interface UserInformationDao extends Dao<UserInformation> {

    void updateById(int id, UserInformation userInformation) throws DaoException;
}
