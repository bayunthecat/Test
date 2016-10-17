package com.lwd.platform.testing.service.impl;

import com.lwd.platform.testing.model.User;
import com.lwd.platform.testing.repo.CrudDao;
import com.lwd.platform.testing.repo.UserDao;
import com.lwd.platform.testing.service.StringHashProcessor;
import com.lwd.platform.testing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractCrudService<User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private StringHashProcessor hashExtractor;

    @Override
    public User read(int id) {
        return userDao.read(new User(), id);
    }

    @Override
    protected CrudDao<User> getCrudDao() {
        return userDao;
    }
}
