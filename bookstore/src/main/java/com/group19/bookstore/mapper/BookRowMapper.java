package com.group19.bookstore.mapper;

import com.group19.bookstore.models.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book()
                .setId(rs.getInt("id"))
                .setAuthor(rs.getString("author"))
                .setGenre(rs.getString("genre"))
                .setTitle(rs.getString("title"))
                .setPublisher(rs.getString("publisher"))
                .setRating(rs.getDouble("rating"))
                .setUnitsSold(rs.getInt("unitsSold"))
                .setPrice(rs.getDouble("price"));
    }
}
