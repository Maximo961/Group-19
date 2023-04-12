package com.group19.bookstore.controller.impl;

import com.group19.bookstore.controller.BookDetailsController;
import com.group19.bookstore.models.Author;
import com.group19.bookstore.models.Book;
import com.group19.bookstore.repository.AuthorRepository;
import com.group19.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class BookDetailsControllerImpl implements BookDetailsController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookDetailsControllerImpl(final BookRepository bookRepository, final AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> getBooksByAuthorId(String authorId) {
        Author author = authorRepository.findById(Integer.valueOf(authorId));

        if (author == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Count not find author for given id: " + authorId
            );
        }

        return bookRepository.findBooksByAuthor(author.getName());
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        Book book = bookRepository.findBookByIsbn(isbn);

        if (book == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Count not find book for given isbn: " + isbn
            );
        }

        return book;
    }
}
