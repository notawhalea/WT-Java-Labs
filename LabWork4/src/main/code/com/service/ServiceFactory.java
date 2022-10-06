package main.code.com.service;

import main.code.com.service.description.*;
import main.code.com.service.impl.*;

public class ServiceFactory {

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return Holder.INSTANCE;
    }



    private final UserOrderService userOrderService=new UserOrderServiceImpl();
    private final UserInformationService userInformationService=new UserInformationServiceImpl();
    private final ApartmentService apartmentService=new ApartmentServiceImpl();
    private final UserService userService=new UserServiceImpl();
    private final RoleService roleService=new RoleServiceImpl();


    public ApartmentService getApartmentService() {
        return apartmentService;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public UserService getUserService() {
        return userService;
    }

    public UserOrderService getUserOrderService() {
        return userOrderService;
    }

    public UserInformationService getUserInformationService() {
        return userInformationService;
    }

    private static class Holder {
        static final ServiceFactory INSTANCE = new ServiceFactory();
    }
}

