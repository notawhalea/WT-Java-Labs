package main.code.com.dao.impl;

import main.code.com.dao.AbstractDao;
import main.code.com.dao.Table;
import main.code.com.dao.description.UserOrderDao;
import main.code.com.dao.mapper.RowMapperFactory;
import main.code.com.entity.UserOrder;
import main.code.com.exeptions.DaoException;

import java.sql.Timestamp;
import java.util.List;

public class UserOrderDaoImpl extends AbstractDao<UserOrder> implements UserOrderDao {
    private static final String FIND_USER_ORDERS_BY_STATUS_QUERY = "SELECT * FROM " + Table.USER_ORDER + " WHERE status=?";
    private static final String UPDATE_USER_ORDER_STATUS_BY_ID_QUERY = "UPDATE " + Table.USER_ORDER + " SET status=? WHERE id=?";
    private static final String SAVE_USER_ORDER_QUERY = "INSERT INTO " + Table.USER_ORDER + " (status, start_time, lease_duration,  user_id, apartment_id) VALUES (?, ?, ?, ?,?)";
    private static final String FIND_USER_ORDERS_BY_USER_ID_QUERY="SELECT * FROM " + Table.USER_ORDER + " WHERE user_id=?";
    private static final String FIND_USER_ORDERS_BY_APARTMENT_ID="SELECT * FROM " + Table.USER_ORDER + " WHERE apartment_id=?";


    public UserOrderDaoImpl() {
        super(RowMapperFactory.getInstance().getUserOrderRowMapper(), Table.USER_ORDER);
    }

    @Override
    public List<UserOrder> findByStatus(String status) throws DaoException {
        return executeQuery(FIND_USER_ORDERS_BY_STATUS_QUERY, status);
    }

    @Override
    public List<UserOrder> findByApartmentID(int apartmentId) throws DaoException {
        return executeQuery(FIND_USER_ORDERS_BY_APARTMENT_ID, apartmentId);
    }

    @Override
    public void updateStatusById(long id, String status) throws DaoException {
        executeUpdateQuery(UPDATE_USER_ORDER_STATUS_BY_ID_QUERY, status, id);
    }

    @Override
    public List<UserOrder> findByNotThisTime(Timestamp startTime, int leaseDuration) throws DaoException {
        return executeQuery(FIND_USER_ORDERS_BY_STATUS_QUERY,startTime,leaseDuration);
    }

    @Override
    public int save(UserOrder userOrder) throws DaoException {
        return executeInsertQuery(SAVE_USER_ORDER_QUERY, userOrder.getStatus(),userOrder.getStartTime(),
                userOrder.getLeaseDuration(),userOrder.getUserId(),userOrder.getApartmentId());
    }

    @Override
    public List<UserOrder> findByUserId(int userId) throws DaoException {
        return executeQuery(FIND_USER_ORDERS_BY_USER_ID_QUERY,userId);
    }
}
