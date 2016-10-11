package com.lwd.platform.testing.repo.mysql;

import com.lwd.platform.testing.model.Answer;
import com.lwd.platform.testing.repo.AnswerDao;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlAnswerDao extends AbstractCrudDao<Answer> implements AnswerDao {
}
