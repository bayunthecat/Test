package com.lwd.platform.testing.service.impl;

import com.lwd.platform.testing.model.User;
import com.lwd.platform.testing.repo.UserDao;
import com.lwd.platform.testing.service.UserService;
import com.lwd.platform.testing.util.constant.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service(Const.Bean.USER_DETAILS_SERVICE)
public class TestingUserDetailService implements UserDetailsService {

    private UserService userService;

    public TestingUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getUserByEmail(email);
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPasswordHash(),
                user.getRoles());
    }
}