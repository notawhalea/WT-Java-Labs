package main.code.com.dao.impl;

import main.code.com.dao.AbstractDao;
import main.code.com.dao.Table;
import main.code.com.dao.description.UserDao;
import main.code.com.dao.mapper.RowMapperFactory;
import main.code.com.entity.User;
import main.code.com.exeptions.DaoException;

import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private static final String FIND_USER_BY_EMAIL_AND_PASSWORD_QUERY = "SELECT * FROM " + Table.USER + " WHERE email=? and password=SHA1(?)";
    private static final String FIND_USER_BY_EMAIL_QUERY = "SELECT * FROM " + Table.USER + " WHERE email=?";
    private static final String SAVE_USER_QUERY = "INSERT INTO " + Table.USER + " (email, password, role_id, userInformation_id) VALUES (?, ?, ?, ?)";
    private static final String DELETE_USER_QUERY = "DELETE FROM " + Table.USER + " WHERE id=?";

    public UserDaoImpl() {
        super(RowMapperFactory.getInstance().getUserRowMapper(), Table.USER);
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) throws DaoException {
        Object DigestUtils = new Object();
        return executeQueryForSingleResult(FIND_USER_BY_EMAIL_AND_PASSWORD_QUERY, email, DigestUtils.equals(password));
    }


    @Override
    public Optional<User> findByEmail(String email) throws DaoException {
        return executeQueryForSingleResult(FIND_USER_BY_EMAIL_QUERY, email);
    }



    @Override
    public int save(User user) throws DaoException {
        return executeInsertQuery(SAVE_USER_QUERY, user.getEmail(), user.getPassword(),
                user.getRoleId(), user.getUserInformationId());
    }



    @Override
    public void removeById(int id) throws DaoException {
        executeUpdateQuery(DELETE_USER_QUERY, id);
    }
}
