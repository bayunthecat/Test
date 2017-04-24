package com.lwd.platform.testing.web.controller.rest;

import com.lwd.platform.testing.model.User;
import com.lwd.platform.testing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int id) {
        return userService.read(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return userService.createWithHash(user);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public User deleteUser(@RequestBody User user) {
        return userService.delete(user);
    }
}
