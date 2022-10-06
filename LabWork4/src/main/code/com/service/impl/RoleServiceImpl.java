package main.code.com.service.impl;

import main.code.com.dao.DaoFactory;
import main.code.com.dao.description.RoleDao;
import main.code.com.entity.Role;
import main.code.com.exeptions.DaoException;
import main.code.com.exeptions.ServiceException;
import main.code.com.service.description.RoleService;

import java.util.Optional;

public class RoleServiceImpl implements RoleService {




    @Override
    public Optional<Role> retrieveRoleById(int roleId) throws ServiceException {
        try {
            RoleDao roleDao = DaoFactory.getInstance().getRoleDao();
            Optional<Role> result;
            result = roleDao.findById(roleId);
            return result;
        } catch (DaoException e) {

            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public Optional<Role> retrieveRoleByRoleName(String roleName) throws ServiceException {
        try {
            RoleDao roleDao = DaoFactory.getInstance().getRoleDao();
            Optional<Role> result;
            result = roleDao.findByName(roleName);
            return result;
        } catch (DaoException e) {

            throw new ServiceException(e.getMessage(), e);
        }
    }
}