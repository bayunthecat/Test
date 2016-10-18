package com.lwd.platform.testing.repo;

import com.lwd.platform.testing.model.User;

public interface UserDao extends CrudDao<User> {

    User getUserByEmail(String email);
}
