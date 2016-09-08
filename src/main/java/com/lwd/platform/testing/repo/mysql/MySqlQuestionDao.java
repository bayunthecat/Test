package com.lwd.platform.testing.repo.mysql;

import com.lwd.platform.testing.model.Question;
import com.lwd.platform.testing.repo.QuestionDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySqlQuestionDao extends AbstractCrudDao<Question> implements QuestionDao {

    @Autowired
    public MySqlQuestionDao(SessionFactory factory) {
        super(factory);
    }

    @Override
    public List<Question> createQuestions(List<Question> questions) {
        questions.stream().forEach(this::create);
        return questions;
    }
}
