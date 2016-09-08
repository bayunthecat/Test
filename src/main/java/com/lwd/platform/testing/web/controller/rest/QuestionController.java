package com.lwd.platform.testing.web.controller.rest;

import com.lwd.platform.testing.model.Question;
import com.lwd.platform.testing.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/question")
@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Question createQuestion(@RequestBody Question question) {
        return questionService.create(question);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Question getQuestion(@PathVariable int id) {
        return questionService.read(id);
    }
}
