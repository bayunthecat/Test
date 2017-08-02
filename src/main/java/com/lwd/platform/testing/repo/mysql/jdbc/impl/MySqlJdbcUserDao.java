package com.lwd.platform.testing.repo.mysql.jdbc.impl;

import com.lwd.platform.testing.annotations.Cached;
import com.lwd.platform.testing.model.business.User;
import com.lwd.platform.testing.repo.CrudDao;
import com.lwd.platform.testing.repo.UserDao;
import com.lwd.platform.testing.repo.mysql.jdbc.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;

@Cached
@Repository
public class MySqlJdbcUserDao implements UserDao, CrudDao<User> {

    private static final String INSERT_USER = "INSERT INTO user (email) VALUES (?)";

    private static final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE id = ?";

    private static final String UPDATE_USER = "UPDATE user SET email = ?, password = ? WHERE id = ?";

    private static final String DELETE_USER = "DELETE FROM user WHERE id = ?";

    private static final String SELECT_USER_BY_EMAIL = "SELECT * FROM user JOIN userrole ON (user.id = userrole.userId) JOIN role ON (userrole.roleId = role.id) WHERE email = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlJdbcUserDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User create(User user) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            int parameter = 1;
            statement.setObject(parameter++, user.getEmail());
            statement.setObject(parameter, user.getPasswordHash());
            return statement;
        }, holder);
        return user;
    }

    @Cached
    @Override
    public User read(int id) {
        return jdbcTemplate.queryForObject(SELECT_USER_BY_ID, new Object[] {id}, new UserRowMapper());
    }

    @Override
    public User update(User user) {
        return jdbcTemplate.update(UPDATE_USER, user.getEmail(), user.getPasswordHash(), user.getId()) != 0 ? user : null;
    }

    @Override
    public User getUserByEmail(String email) {
        return jdbcTemplate.queryForObject(SELECT_USER_BY_EMAIL, new Object[] {email}, new UserRowMapper());
    }

    @Override
    public User delete(User user) {
        return jdbcTemplate.update(DELETE_USER, user.getId()) != 0 ? user : null;
    }
}
