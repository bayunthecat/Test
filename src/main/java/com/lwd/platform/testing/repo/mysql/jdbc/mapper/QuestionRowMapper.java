package com.lwd.platform.testing.repo.mysql.jdbc.mapper;

import com.lwd.platform.testing.model.business.Question;
import com.lwd.platform.testing.model.business.Topic;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionRowMapper implements RowMapper<Question> {

    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        Question question = new Question();
        question.setId(rs.getInt("q.id"));
        question.setContent(rs.getString("q.content"));
        question.setTopic(mapTopic(rs));
        return question;
    }

    private Topic mapTopic(ResultSet rs) throws SQLException {
        Topic topic = new Topic();
        topic.setId(rs.getInt("t.id"));
        topic.setId(rs.getInt("t.name"));
        return topic;
    }
}
