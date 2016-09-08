package com.lwd.platform.testing.repo.mysql;

import com.lwd.platform.testing.model.Test;
import com.lwd.platform.testing.repo.TestDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySqlTestDao extends AbstractCrudDao<Test> implements TestDao {

    @Autowired
    public MySqlTestDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
