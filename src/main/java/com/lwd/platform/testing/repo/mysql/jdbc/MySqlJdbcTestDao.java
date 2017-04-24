package com.lwd.platform.testing.repo.mysql.jdbc;

import java.sql.PreparedStatement;
import javax.sql.DataSource;

import com.lwd.platform.testing.model.User;
import com.lwd.platform.testing.repo.CrudDao;
import com.lwd.platform.testing.repo.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlJdbcTestDao implements CrudDao<User>, UserDao{

    private static final String INSERT_USER = "";

    private JdbcTemplate template;

    public MySqlJdbcTestDao(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public User create(User user) {
        KeyHolder holder = new GeneratedKeyHolder();
        template.update(con -> {
            PreparedStatement stmt = con.prepareStatement(INSERT_USER);
            return stmt;
        }, holder);
        user.setId(holder.getKey().intValue());
        return user;
    }

    @Override
    public User read(int id) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User delete(User user) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }
}
