package com.group19.bookstore.dao;


import com.group19.bookstore.models.Book;

import java.util.List;

/*
 * Defines the methods for the Book data access object (dao).
 */
public interface BookDao {

    List<Book> retrieveAll();

    Book retrieveBookByIsbn(String isbn);

    void insertBook(Book book);

    void updateBook(Book book);

    void executeUpdateBook(Book book);

    void deleteBook(Book book);
}
