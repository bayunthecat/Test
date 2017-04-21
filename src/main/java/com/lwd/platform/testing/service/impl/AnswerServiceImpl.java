package com.lwd.platform.testing.service.impl;

import com.lwd.platform.testing.model.Answer;
import com.lwd.platform.testing.repo.AnswerDao;
import com.lwd.platform.testing.repo.CrudDao;
import com.lwd.platform.testing.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl extends AbstractCrudService<Answer> implements AnswerService {

    @Autowired
    private AnswerDao answerDao;

    @Override
    public Answer read(int id) {
        return answerDao.read(id);
    }

    @Override
    protected CrudDao<Answer> getCrudDao() {
        return answerDao;
    }
}
