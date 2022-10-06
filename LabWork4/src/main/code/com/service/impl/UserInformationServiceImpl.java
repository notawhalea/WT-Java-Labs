package main.code.com.service.impl;

import main.code.com.dao.DaoFactory;
import main.code.com.dao.impl.UserInformationDaoImpl;
import main.code.com.entity.User;
import main.code.com.entity.UserInformation;
import main.code.com.exeptions.DaoException;
import main.code.com.exeptions.ServiceException;
import main.code.com.service.description.UserInformationService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UserInformationServiceImpl implements UserInformationService {


    @Override
    public Optional<UserInformation> retrieveUserInformationById(int userInformationId) throws ServiceException {
        try {
            UserInformationDaoImpl userInformationDao = DaoFactory.getInstance().getUserInformationDao();
            Optional<UserInformation> result;
            result = userInformationDao.findById(userInformationId);
            return result;
        } catch (DaoException e) {

            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<UserInformation> getUserInformationFromUsers(List<User> users) throws ServiceException {
        List<UserInformation> userInformation = new LinkedList<>();
        try {
            for (User user : users) {
                Optional<UserInformation> information = retrieveUserInformationById(user.getUserInformationId());
                if (information.isPresent()) {
                    if (!userInformation.contains(information.get())) {
                        userInformation.add(information.get());
                    }
                }
            }
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage(), e);
        }

        return userInformation;
    }
}
