package com.lwd.platform.testing.repo.mysql.hibernate;

import com.lwd.platform.testing.model.Question;
import com.lwd.platform.testing.repo.QuestionDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySqlHibernateQuestionDao extends AbstractHibernateCrudDao<Question> implements QuestionDao {

    @Override
    public List<Question> createQuestions(List<Question> questions) {
        questions.forEach(this::create);
        return questions;
    }
}
