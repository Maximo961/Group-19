package com.group19.bookstore.dao;

import com.group19.bookstore.models.Author;

import java.util.List;

/*
 * Defines the methods for the Author data access object (dao).
 */
public interface AuthorDao {

    List<Author> retrieveAll();

    void insertAuthor(Author author);

    void updateAuthor(Author author);

    void executeUpdateAuthor(Author author);

    void deleteAuthor(Author author);


}
