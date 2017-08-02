package com.lwd.platform.testing.repo.mysql.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.lwd.platform.testing.model.business.Answer;
import org.springframework.jdbc.core.RowMapper;

public class AnswerRowMapper implements RowMapper<Answer> {

    @Override
    public Answer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Answer answer = new Answer();
        answer.setId(rs.getInt("id"));
        answer.setContent(rs.getString("content"));
        return answer;
    }

}
