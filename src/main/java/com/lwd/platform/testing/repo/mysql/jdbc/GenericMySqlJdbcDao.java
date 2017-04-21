package com.lwd.platform.testing.repo.mysql.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class GenericMySqlJdbcDao {

    protected JdbcTemplate jdbcTemplate;

    @Autowired
    public GenericMySqlJdbcDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    protected int create(String sql, KeyHolder holder, Object... parameters) {
        return jdbcTemplate.update(con -> {
            int parameter = 0;
            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (Object param : parameters) {
                statement.setObject(++parameter, param);
            }
            return statement;
        }, holder);
    }

    protected <T> T read(String sql, RowMapper<T> mapper, Object... parameters) {
        return jdbcTemplate.queryForObject(sql, mapper, parameters);
    }

    protected int delete(String sql, Object... parameters) {
        return jdbcTemplate.update(sql, parameters);
    }

    protected int update(String sql, Object... parameters) {
        return jdbcTemplate.update(sql, parameters);
    }
}
