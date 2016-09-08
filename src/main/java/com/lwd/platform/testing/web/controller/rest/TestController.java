package com.lwd.platform.testing.web.controller.rest;

import com.lwd.platform.testing.model.ModelEntity;
import com.lwd.platform.testing.model.Test;
import com.lwd.platform.testing.service.TestService;
import com.lwd.platform.testing.util.constant.Mime;
import com.lwd.platform.testing.util.constant.RequestMappings;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/test")
@RestController
public class TestController {

    private static final Logger LOG = Logger.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = Mime.JSON)
    public ModelEntity createTest(@RequestBody Test test) {
        return testService.create(test);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = Mime.JSON)
    public ModelEntity deleteTest(@RequestBody Test test) {
        return testService.delete(test);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = Mime.JSON)
    public ModelEntity updateTest(@RequestBody Test test) {
        return testService.update(test);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ModelEntity getTest(@PathVariable int id) {
        return testService.read(id);
    }
}
