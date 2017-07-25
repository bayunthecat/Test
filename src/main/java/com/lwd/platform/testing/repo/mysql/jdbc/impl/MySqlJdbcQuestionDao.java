package com.lwd.platform.testing.repo.mysql.jdbc.impl;

import com.lwd.platform.testing.model.Question;
import com.lwd.platform.testing.repo.CrudDao;
import com.lwd.platform.testing.repo.QuestionDao;
import com.lwd.platform.testing.repo.mysql.jdbc.mapper.QuestionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class MySqlJdbcQuestionDao implements CrudDao<Question>, QuestionDao {

    private static final String INSERT_QUESTION = "INSERT INTO question (content, topicId) VALUES (?, ?)";

    //TODO check null cases
    private static final String SELECT_QUESTION_BY_ID = "SELECT q.id, q.content, t.id, t.name FROM question q INNER JOIN topic t ON (q.topicId = t.id) WHERE q.id = 1";

    private static final String DELETE_QUESTION = "DELETE question WHERE id = ?";

    private static final String UPDATE_QUESTION = "UPDATE question SET content = ?, topicId = ? WHERE id = ?";

    private JdbcTemplate template;

    @Autowired
    public MySqlJdbcQuestionDao(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public Question create(Question question) {
        KeyHolder holder = new GeneratedKeyHolder();
        int affectedRows = template.update(con -> {
            int parameter = 1;
            PreparedStatement stmt = con.prepareStatement(INSERT_QUESTION, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(parameter++, question.getContent());
            stmt.setObject(parameter, question.getTopic().getId());
            return stmt;
        }, holder);
        if (affectedRows != 0) {
            question.setId(holder.getKey().intValue());
            return question;
        }
        return null;
    }

    @Override
    public Question read(int id) {
        return template.queryForObject(SELECT_QUESTION_BY_ID, new QuestionRowMapper(), id);
    }

    @Override
    public Question update(Question question) {
        return template.update(UPDATE_QUESTION,
                question.getContent(),
                question.getTopic().getId(),
                question.getId()) != 0 ? question : null;
    }

    @Override
    public Question delete(Question question) {
        return template.update(DELETE_QUESTION, question.getId()) != 0 ? question : null;
    }
}
