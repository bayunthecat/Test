package com.lwd.platform.testing.repo.mysql;

import com.lwd.platform.testing.model.Question;
import com.lwd.platform.testing.repo.QuestionDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySqlQuestionDao extends AbstractCrudDao<Question> implements QuestionDao {

    @Override
    public List<Question> createQuestions(List<Question> questions) {
        questions.stream().forEach(this::create);
        return questions;
    }
}
