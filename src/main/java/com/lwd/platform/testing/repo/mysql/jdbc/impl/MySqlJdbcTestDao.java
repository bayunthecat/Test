package com.lwd.platform.testing.repo.mysql.jdbc.impl;

import com.lwd.platform.testing.model.business.Test;
import com.lwd.platform.testing.repo.CrudDao;
import com.lwd.platform.testing.repo.TestDao;
import com.lwd.platform.testing.repo.mysql.jdbc.mapper.TestRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class MySqlJdbcTestDao implements CrudDao<Test>, TestDao {

    private static final String INSERT_TEST = "INSERT INTO test (name) VALUES (?)";

    private static final String SELECT_TEST_BY_ID = "SELECT * FROM test WHERE id = ?";

    private static final String UPDATE_TEST = "UPDATE test SET name = ? WHERE id = ?";

    private static final String DELETE_TEST_BY_ID = "DELETE * FROM test WHERE id = ?";

    private static final String SELECT_ALL_TESTS = "SELECT * FROM test LIMIT ?,?";

    private JdbcTemplate template;

    @Autowired
    public MySqlJdbcTestDao(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public Test create(Test test) {
        KeyHolder holder = new GeneratedKeyHolder();
        int affectedRows = template.update(con -> {
            PreparedStatement stmt = con.prepareStatement(INSERT_TEST, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, test.getName());
            return stmt;
        }, holder);
        if (affectedRows != 0) {
            test.setId(holder.getKey().intValue());
            return test;
        }
        return null;
    }

    @Override
    public Test read(int id) {
        return template.queryForObject(SELECT_TEST_BY_ID, new TestRowMapper(), id);
    }

    @Override
    public Test update(Test test) {
        return template.update(UPDATE_TEST, test.getName(), test.getId()) != 0 ? test : null;
    }

    @Override
    public Test delete(Test test) {
        return template.update(DELETE_TEST_BY_ID, test.getId()) != 0 ? test : null;
    }

    @Override
    public List<Test> getTests(int count, int offset) {
        return template.query(SELECT_ALL_TESTS, new Object[] {offset, count}, new TestRowMapper());
    }
}
