package com.group19.bookstore.repository;

import com.group19.bookstore.models.Book;

import java.util.List;

/**
 * A dummy repository of the book data for development before a DB is connected.
 * This class will implement the singleton pattern.
 */
public class DummyBookStoreRepository {

    // create an instance
    private static final DummyBookStoreRepository INSTANCE = new DummyBookStoreRepository();
    private List<Book> books;

    // prevent other instances from being made
    private DummyBookStoreRepository(){
        Book HP_PRISONER = new Book().setAuthor("J.K. Rowling").setGenre("Fantasy").setPrice(19.99).setRating(10.0).setTitle("Harry Potter: Prisoner of Azkaban").setUnitsSold(10000);
        Book LOTR_FELLOWSHIP = new Book().setAuthor("J.R.R Tolkien").setGenre("Fantasy").setPrice(29.99).setRating(9.0).setTitle("Lord of the Rings: Fellowship of the Ring").setUnitsSold(1000);

        books = List.of(HP_PRISONER, LOTR_FELLOWSHIP);
    }

    // Getter for Singleton instance
    public static DummyBookStoreRepository getInstance() {
        return INSTANCE;
    }

    // Getter for books list
    public List<Book> getBooks() {
        return this.books;
    }
}
