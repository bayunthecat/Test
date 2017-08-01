package com.lwd.platform.testing.web.controller.rest;

import com.lwd.platform.testing.model.business.ModelEntity;
import com.lwd.platform.testing.model.business.Test;
import com.lwd.platform.testing.service.TestService;
import com.lwd.platform.testing.util.constant.Mime;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/test")
@RestController
public class TestController {

    private static final Logger LOG = Logger.getLogger(TestController.class);

    private TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelEntity getTest(@PathVariable int id) {
        return testService.read(id);
    }

    @RequestMapping(value = "/getAll/count/{count}/offset/{offset}", method = RequestMethod.GET)
    public List<Test> getTests(@PathVariable int count, @PathVariable int offset) {
        return testService.getAll(count, offset);
    }
}
