package com.lwd.platform.testing.repo.mysql.jdbc.impl;

import java.util.List;
import javax.sql.DataSource;

import com.lwd.platform.testing.annotations.Cached;
import com.lwd.platform.testing.model.business.Role;
import com.lwd.platform.testing.repo.CrudDao;
import com.lwd.platform.testing.repo.RoleDao;
import com.lwd.platform.testing.repo.mysql.jdbc.mapper.RoleRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Cached
@Repository
public class MySqlJdbcRoleDao implements CrudDao<Role>, RoleDao {

    private static final String SELECT_ROLE_BY_ID = "SELECT * FROM role WHERE id = ?";

    private static final String SELECT_ROLES_FOR_USER_BY_ID = "SELECT roleId FROM role r JOIN userrole ur ON (r.id = ur.roleId) JOIN user u ON (ur.userID = u.id) WHERE u.id = ?";

    private JdbcTemplate template;

    public MySqlJdbcRoleDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public Role create(Role role) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Role read(int id) {
        return template.queryForObject(SELECT_ROLE_BY_ID, new Object[] {id}, new RoleRowMapper());
    }

    @Override
    public Role update(Role role) {
        return null;
    }

    @Override
    public Role delete(Role role) {
        return null;
    }

    @Override
    public List<Integer> getRolesForUser(int id) {
        return template.queryForList(SELECT_ROLES_FOR_USER_BY_ID, new Object[] {id}, Integer.class);
    }
}