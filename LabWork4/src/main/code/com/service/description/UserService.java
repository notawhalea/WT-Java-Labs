package main.code.com.service.description;

import main.code.com.entity.User;
import main.code.com.entity.UserOrder;
import main.code.com.exeptions.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService {


    Optional<User> login(String email, String password) throws ServiceException;


    boolean register(String name, String surname,  String email, String phone, String password) throws ServiceException;


    Optional<User> retrieveUserById(int userId) throws ServiceException;

    public List<User> getUsersFromOrders(List<UserOrder> orders) throws ServiceException;


}
