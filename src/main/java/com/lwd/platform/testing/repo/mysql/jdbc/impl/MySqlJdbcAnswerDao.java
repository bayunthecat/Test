package com.lwd.platform.testing.repo.mysql.jdbc.impl;

import com.lwd.platform.testing.model.business.Answer;
import com.lwd.platform.testing.repo.AnswerDao;
import com.lwd.platform.testing.repo.CrudDao;
import com.lwd.platform.testing.repo.mysql.jdbc.mapper.AnswerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class MySqlJdbcAnswerDao implements CrudDao<Answer>, AnswerDao {

    private static final String INSERT_ANSWER = "INSERT INTO answer (content, questionId) VALUES (?, ?)";

    private static final String SELECT_ANSWER_BY_ID = "SELECT * FROM answer WHERE id = ?";

    private JdbcTemplate template;

    @Autowired
    public MySqlJdbcAnswerDao(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public Answer create(Answer answer) {
        KeyHolder holder = new GeneratedKeyHolder();
        int affectedRows = template.update(con -> {
            int parameter = 1;
            PreparedStatement stmt = con.prepareStatement(INSERT_ANSWER, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(parameter++, answer.getContent());
            stmt.setObject(parameter, answer.getQuestion().getId());
            return stmt;
        }, holder);
        if (affectedRows != 0) {
            answer.setId(holder.getKey().intValue());
            return answer;
        }
        return null;
    }

    @Override
    public Answer read(int id) {
        return template.queryForObject(SELECT_ANSWER_BY_ID, new Object[] {id}, new AnswerRowMapper());
    }

    @Override
    public Answer update(Answer answer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Answer delete(Answer answer) {
        throw new UnsupportedOperationException();
    }
}
