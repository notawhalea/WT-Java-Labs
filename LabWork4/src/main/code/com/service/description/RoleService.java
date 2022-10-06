package main.code.com.service.description;

import main.code.com.entity.Role;
import main.code.com.exeptions.ServiceException;

import java.util.Optional;

public interface RoleService {

    Optional<Role> retrieveRoleById(int roleId) throws ServiceException;
    Optional<Role> retrieveRoleByRoleName(String roleName) throws ServiceException;

}
