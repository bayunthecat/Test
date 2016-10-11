package com.lwd.platform.testing.service.converter;

import com.lwd.platform.testing.model.User;
import com.lwd.platform.testing.service.StringHashProcessor;
import com.lwd.platform.testing.web.controller.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserBeanConverter implements Converter<UserBean, User>{

    @Autowired
    private StringHashProcessor extractor;

    @Override
    public User convert(UserBean source) {
        User user = new User();
        user.setEmail(source.getEmail());
        user.setPasswordHash(extractor.hash(source.getPassword()));
        return user;
    }

}
