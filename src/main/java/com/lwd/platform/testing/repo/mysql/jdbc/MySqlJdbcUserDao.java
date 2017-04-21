package com.lwd.platform.testing.repo.mysql.jdbc;

import com.lwd.platform.testing.model.User;
import com.lwd.platform.testing.repo.CrudDao;
import com.lwd.platform.testing.repo.UserDao;
import com.lwd.platform.testing.repo.mysql.jdbc.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;

public class MySqlJdbcUserDao implements UserDao, CrudDao<User> {

    private static final String INSERT_USER = "INSERT INTO user (email, role) VALUES (?,?)";

    private static final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE id = ?";
    public static final String UPDATE_USER = "UPDATE user SET email = ?, password = ? WHERE id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlJdbcUserDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User create(User user) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(INSERT_USER);
            int parameter = 1;
            statement.setObject(parameter++, user.getEmail());
            statement.setObject(parameter, user.getPasswordHash());
            return statement;
        }, holder);
        return user;
    }

    @Override
    public User read(int id) {
        return jdbcTemplate.queryForObject(SELECT_USER_BY_ID, new UserRowMapper());
    }

    @Override
    public User update(User user) {
        //TODO make generic parameter extraction
        return jdbcTemplate.update(UPDATE_USER, 0, 1) != 0 ? user : null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User delete(User user) {
        return null;
    }
}
