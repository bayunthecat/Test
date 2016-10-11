package com.lwd.platform.testing.service;

import com.lwd.platform.testing.model.User;
import com.lwd.platform.testing.web.controller.bean.UserBean;

public interface UserService extends CrudService<User> {

    User create(UserBean userBean);
}
