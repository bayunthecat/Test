package com.lwd.platform.testing.repo.mysql.hibernate;

import com.lwd.platform.testing.model.Test;
import com.lwd.platform.testing.repo.TestDao;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySqlHibernateTestDao extends AbstractHibernateCrudDao<Test> implements TestDao {

    @Autowired
    private Session session;

    @SuppressWarnings("unchecked")
    @Override
    public List<Test> getTests(int count, int offset) {
        return session.createCriteria(Test.class).setMaxResults(count).setFirstResult(offset).list();
    }
}
