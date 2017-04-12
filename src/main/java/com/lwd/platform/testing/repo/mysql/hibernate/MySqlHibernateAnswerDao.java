package com.lwd.platform.testing.repo.mysql.hibernate;

import com.lwd.platform.testing.model.Answer;
import com.lwd.platform.testing.repo.AnswerDao;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlHibernateAnswerDao extends AbstractHibernateCrudDao<Answer> implements AnswerDao {
}
