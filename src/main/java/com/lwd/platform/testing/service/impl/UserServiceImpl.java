package com.lwd.platform.testing.service.impl;

import java.util.List;

import com.lwd.platform.testing.model.business.Role;
import com.lwd.platform.testing.model.business.User;
import com.lwd.platform.testing.repo.CrudDao;
import com.lwd.platform.testing.repo.UserDao;
import com.lwd.platform.testing.service.RoleService;
import com.lwd.platform.testing.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractCrudService<User> implements UserService {

    private PasswordEncoder encoder;

    private UserDao userDao;

    private RoleService roleService;

    public UserServiceImpl(PasswordEncoder encoder, UserDao userDao, RoleService roleService) {
        this.encoder = encoder;
        this.userDao = userDao;
        this.roleService = roleService;
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
        return fetchRoles(user);
    }

    @Override
    public User read(int id) {
        User user = userDao.read(id);
        return fetchRoles(user);
    }

    private User fetchRoles(User user) {
        List<Role> roles = roleService.getRolesForUser(user.getId());
        user.setRoles(roles);
        return user;
    }
}