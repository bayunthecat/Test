package com.lwd.platform.testing.service.impl;

import com.lwd.platform.testing.model.User;
import com.lwd.platform.testing.repo.UserDao;
import com.lwd.platform.testing.util.constant.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(Const.Bean.USER_DETAILS_SERVICE)
public class TestingUserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        User user = userDao.read(new User(), Integer.parseInt(id));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPasswordHash(), user.getRoles());
    }
}
