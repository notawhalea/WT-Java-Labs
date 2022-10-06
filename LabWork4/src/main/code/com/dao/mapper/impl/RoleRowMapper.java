package main.code.com.dao.mapper.impl;

import main.code.com.dao.mapper.Column;
import main.code.com.dao.mapper.RowMapper;
import main.code.com.entity.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRowMapper implements RowMapper<Role> {

    @Override
    public Role map(ResultSet resultSet) throws SQLException {
        Role role = new Role();
        role.setId(resultSet.getInt(Column.ID));
        role.setName(resultSet.getString(Column.ROLE_NAME));
        return role;
    }
}