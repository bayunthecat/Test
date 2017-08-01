package com.lwd.platform.testing.model.business;

import java.util.List;

public class Test extends ModelEntity {

    public Test() {
    }

    public Test(int id) {
        super(id);
    }

    private String name;

    private List<Question> questions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
