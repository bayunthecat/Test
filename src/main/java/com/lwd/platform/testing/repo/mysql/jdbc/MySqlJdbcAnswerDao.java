package com.lwd.platform.testing.repo.mysql.jdbc;

import com.lwd.platform.testing.model.Answer;
import com.lwd.platform.testing.repo.AnswerDao;
import com.lwd.platform.testing.repo.CrudDao;
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

    private JdbcTemplate template;

    @Autowired
    public MySqlJdbcAnswerDao(DataSource dataSource) {
        template = new JdbcTemplate();
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
        return null;
    }

    @Override
    public Answer update(Answer answer) {
        return null;
    }

    @Override
    public Answer delete(Answer answer) {
        return null;
    }
}
