package com.lwd.platform.testing.web.controller.rest;

import com.lwd.platform.testing.model.User;
import com.lwd.platform.testing.service.UserService;
import com.lwd.platform.testing.web.controller.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int id) {
        return userService.read(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User createUser(@RequestBody UserBean bean) {
        return userService.create(bean);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public User deleteUser(@RequestBody User user) {
        return userService.delete(user);
    }
}
