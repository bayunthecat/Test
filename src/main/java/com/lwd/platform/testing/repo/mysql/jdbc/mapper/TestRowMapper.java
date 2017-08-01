package com.lwd.platform.testing.repo.mysql.jdbc.mapper;

import com.lwd.platform.testing.model.business.Test;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestRowMapper implements RowMapper<Test> {

    @Override
    public Test mapRow(ResultSet rs, int rowNum) throws SQLException {
        Test test = new Test();
        test.setId(rs.getInt("id"));
        test.setName(rs.getString("name"));
        return test;
    }
}
