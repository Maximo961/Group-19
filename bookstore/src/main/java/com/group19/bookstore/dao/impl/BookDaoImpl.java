package com.group19.bookstore.dao.impl;

import com.group19.bookstore.dao.BookDao;
import com.group19.bookstore.mapper.BookRowMapper;
import com.group19.bookstore.models.Book;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class was made following
 * https://dzone.com/articles/bounty-spring-boot-and-postgresql-database
 */
@Repository
public class BookDaoImpl implements BookDao {

    private final NamedParameterJdbcTemplate template;

    public BookDaoImpl(final NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Book> retrieveAll() {
        return template.query("select * from book", new BookRowMapper());
    }

    @Override
    public void insertBook(Book book) {
        final String sql = "insert into book(author, genre, price, publisher, rating, title, unitssold, id) values(:author, :genre, :price, :publisher, :rating, :title, :unitssold, :id)";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", book.getId())
                .addValue("title", book.getTitle())
                .addValue("author", book.getAuthor())
                .addValue("genre", book.getGenre())
                .addValue("price", book.getPrice())
                .addValue("publisher", book.getPublisher())
                .addValue("rating", book.getRating())
                .addValue("unitssold", book.getUnitsSold());
        template.update(sql,param, holder);
    }

    @Override
    public void updateBook(Book book) {
        final String sql = "update book set author=:author, genre=:genre, price=:price, publisher=:publisher, rating=:rating, title=:title, unitssold=:unitssold where id=:id)";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", book.getId())
                .addValue("title", book.getTitle())
                .addValue("author", book.getAuthor())
                .addValue("genre", book.getGenre())
                .addValue("price", book.getPrice())
                .addValue("publisher", book.getPublisher())
                .addValue("rating", book.getRating())
                .addValue("unitssold", book.getUnitsSold());
        template.update(sql,param, holder);
    }

    @Override
    public void executeUpdateBook(Book book) {
        final String sql = "update book set author=:author, genre=:genre, price=:price, publisher=:publisher, rating=:rating, title=:title, unitssold=:unitssold where id=:id)";

        Map<String, Object> map = new HashMap<>();
        map.put("title", book.getTitle());
        map.put("author", book.getAuthor());
        map.put("genre", book.getGenre());
        map.put("price", book.getPrice());
        map.put("publisher", book.getPublisher());
        map.put("rating", book.getRating());
        map.put("unitssold", book.getUnitsSold());

        template.execute(sql, map, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }

    @Override
    public void deleteBook(Book book) {
        final String sql = "delete from book where id=:id";

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("id", book.getId());

        template.execute(sql,map,new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }
}
