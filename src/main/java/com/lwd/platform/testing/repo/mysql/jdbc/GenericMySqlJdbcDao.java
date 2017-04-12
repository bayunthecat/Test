package com.lwd.platform.testing.repo.mysql.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class GenericMySqlJdbcDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GenericMySqlJdbcDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    protected <T> T update(String sql) {
        return null;
    }
}
