package main.code.com.service.description;

import main.code.com.entity.User;
import main.code.com.entity.UserInformation;
import main.code.com.exeptions.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserInformationService {

    Optional<UserInformation> retrieveUserInformationById(int userInformationId) throws ServiceException;


    List<UserInformation> getUserInformationFromUsers(List<User> users) throws ServiceException;
}
