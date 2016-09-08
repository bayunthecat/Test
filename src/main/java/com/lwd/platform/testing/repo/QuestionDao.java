package com.lwd.platform.testing.repo;

import com.lwd.platform.testing.model.Question;

import java.util.List;

public interface QuestionDao extends CrudDao<Question> {

    List<Question> createQuestions(List<Question> questions);

}
