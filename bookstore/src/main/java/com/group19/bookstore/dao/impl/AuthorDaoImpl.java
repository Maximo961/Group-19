package com.group19.bookstore.dao.impl;

import com.group19.bookstore.dao.AuthorDao;
import com.group19.bookstore.mapper.AuthorRowMapper;
import com.group19.bookstore.models.Author;
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
public class AuthorDaoImpl implements AuthorDao {

    private final NamedParameterJdbcTemplate template;

    public AuthorDaoImpl(final NamedParameterJdbcTemplate template) {
        this.template = template;
    }
    @Override
    public List<Author> retrieveAll() {
        return template.query("select * from author", new AuthorRowMapper());
    }

    @Override
    public void insertAuthor(Author author) {
        final String sql = "insert into author(name, id) values(:name,:id)";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", author.getId())
                .addValue("name", author.getName());
        template.update(sql,param, holder);
    }

    @Override
    public void updateAuthor(Author author) {
        final String sql = "update author set name=:name where id=:id)";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", author.getId())
                .addValue("name", author.getName());
        template.update(sql,param, holder);
    }

    /**
     * This method is similar to updateAuthor but uses EXECUTE, which is
     * similar to a prepared statement:
     * https://www.postgresql.org/docs/current/sql-execute.html
     *
     * @param author - a model of the author to update
     */
    @Override
    public void executeUpdateAuthor(Author author) {
        final String sql = "update author set name=:name where id=:id)";

        Map<String, Object> map = new HashMap<>();
        map.put("id", author.getId());
        map.put("name", author.getName());

        template.execute(sql, map, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }

    @Override
    public void deleteAuthor(Author author) {
        final String sql = "delete from author where id=:id";

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("id", author.getId());

        template.execute(sql,map,new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }
}
