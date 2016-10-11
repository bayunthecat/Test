package com.lwd.platform.testing.service.impl;

import com.lwd.platform.testing.model.Test;
import com.lwd.platform.testing.repo.CrudDao;
import com.lwd.platform.testing.repo.QuestionDao;
import com.lwd.platform.testing.repo.TestDao;
import com.lwd.platform.testing.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl extends AbstractCrudService<Test> implements TestService {

    @Autowired
    private TestDao testDao;

    @Autowired
    private QuestionDao questionDao;

    @Override
    public Test read(int id) {
        return testDao.read(new Test(), id);
    }

    @Override
    protected CrudDao<Test> getCrudDao() {
        return testDao;
    }

    @Override
    public List<Test> getAll(int count, int offset) {
        return testDao.getTests(count, offset);
    }
}
