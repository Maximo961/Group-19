package com.group19.bookstore.repository;

import com.group19.bookstore.models.Author;

import java.util.List;

/**
 * A dummy repository of the author data for development before a DB is connected.
 * This class will implement the singleton pattern.
 */
public class DummyAuthorRepository {
    private static final DummyAuthorRepository INSTANCE = new DummyAuthorRepository();
    private List<Author> authorList;
    private DummyAuthorRepository(){
        Author JK_Rowling = new Author().setName("J.K. Rowling").setId(7);
        Author JRR_Tolkien = new Author().setName("J.R.R Tolkien").setId(3);

        authorList = List.of(JK_Rowling,JRR_Tolkien);

    }

    public static DummyAuthorRepository getInstance(){
        return INSTANCE;
    }

    public List<Author> getAuthorList() {
        return this.authorList;
    }

}
