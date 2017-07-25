package com.lwd.platform.testing.repo.mysql.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.lwd.platform.testing.model.Role;
import org.springframework.jdbc.core.RowMapper;

public class RoleRowMapper implements RowMapper<Role> {

    @Override
    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
        Role role = new Role();
        role.setId(rs.getInt("id"));
        role.setName(rs.getString("name"));
        return role;
    }
}
