package com.lwd.platform.testing.repo.mysql;

import com.lwd.platform.testing.model.User;
import com.lwd.platform.testing.repo.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlUserDao extends AbstractCrudDao<User> implements UserDao {
}