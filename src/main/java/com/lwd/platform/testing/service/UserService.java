package com.lwd.platform.testing.service;

import com.lwd.platform.testing.model.User;

public interface UserService extends CrudService<User> {

    /**
     * Intends to be used upon the creation of the user.
     * @param user instance without hashed password
     * @return newly created user with hashed password
     */
    User createWithHash(User user);

    User getUserByEmail(String email);
}
