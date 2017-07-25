package com.lwd.platform.testing.service.impl;

import java.util.List;

import com.lwd.platform.testing.model.Role;
import com.lwd.platform.testing.model.User;
import com.lwd.platform.testing.repo.CrudDao;
import com.lwd.platform.testing.repo.RoleDao;
import com.lwd.platform.testing.repo.UserDao;
import com.lwd.platform.testing.service.StringHashProcessor;
import com.lwd.platform.testing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractCrudService<User> implements UserService {

    private PasswordEncoder encoder;

    private UserDao userDao;

    private RoleDao roleDao;

    public UserServiceImpl(PasswordEncoder encoder, UserDao userDao, RoleDao roleDao) {
        this.encoder = encoder;
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public User createWithHash(User user) {
        user.setPasswordHash(encoder.encode(user.getPasswordHash()));
        return userDao.create(user);
    }

    @Override
    protected CrudDao<User> getCrudDao() {
        return userDao;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = userDao.getUserByEmail(email);
        List<Role> roles = roleDao.getRolesForUser(user.getId());
        user.setRoles(roles);
        return user;
    }
}