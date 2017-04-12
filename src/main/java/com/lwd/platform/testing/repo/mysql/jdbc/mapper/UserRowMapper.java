package com.lwd.platform.testing.repo.mysql.jdbc.mapper;

import com.lwd.platform.testing.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user  = new User();
        user.setId(rs.getInt("id"));
        user.setEmail(rs.getString("email"));
        user.setPasswordHash(rs.getString("password"));
        return user;
    }
}
