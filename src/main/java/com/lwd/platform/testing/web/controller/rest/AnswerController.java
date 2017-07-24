package com.lwd.platform.testing.web.controller.rest;

import com.lwd.platform.testing.model.Answer;
import com.lwd.platform.testing.service.AnswerService;
import com.lwd.platform.testing.util.constant.Mime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/answer")
@RestController
public class AnswerController {

    private AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = Mime.JSON)
    public Answer createAnswer(@RequestBody Answer answer) {
        return answerService.create(answer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Answer getAnswer(@PathVariable int id) {
        return answerService.read(id);
    }
}
