package com.lwd.platform.testing.service.impl;

import com.lwd.platform.testing.model.Question;
import com.lwd.platform.testing.repo.CrudDao;
import com.lwd.platform.testing.repo.QuestionDao;
import com.lwd.platform.testing.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionServiceImpl extends AbstractCrudService<Question> implements QuestionService {

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    protected CrudDao<Question> getCrudDao() {
        return questionDao;
    }

    @Override
    public Question read(int id) {
        return questionDao.read(new Question(), id);
    }
}
