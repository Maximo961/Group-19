package com.group19.bookstore.mapper;

import com.group19.bookstore.models.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRowMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Author().setId(rs.getInt("id")).setName(rs.getString("name"));
    }
}
