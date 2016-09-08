package com.lwd.platform.testing.web.controller;

import com.lwd.platform.testing.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @Autowired
    private TestService service;

    @RequestMapping(value = "/index")
    public String getIndex() {

        return "index";
    }
}
