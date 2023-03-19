package com.group19.bookstore.controller.impl;

import com.group19.bookstore.controller.BookDetailsController;
import com.group19.bookstore.dao.AuthorDao;
import com.group19.bookstore.dao.BookDao;
import com.group19.bookstore.models.Author;
import com.group19.bookstore.models.Book;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class BookDetailsControllerImpl implements BookDetailsController {
    private final BookDao bookDao;
    private final AuthorDao authorDao;

    @Autowired
    public BookDetailsControllerImpl(final BookDao bookDao,  final AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }

    @Override
    public List<Book> getBooksByAuthorId(String authorId) {
        List<Author> authorsFromDao = authorDao.retrieveAll();
        List<Book> booksFromDao = bookDao.retrieveAll();

        Author requestedAuthor = authorsFromDao.stream()
                .filter(author -> StringUtils.equalsAnyIgnoreCase(String.valueOf(author.getId()), authorId))
                .findFirst()
                .orElse(null);

        if (requestedAuthor == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Count not find author for given id: " + authorId
            );
        }

        List<Book> authorBooks = booksFromDao.stream()
                .filter(book -> StringUtils.equalsAnyIgnoreCase(book.getAuthor(), requestedAuthor.getName()))
                .findAny().stream().toList();

        return authorBooks;
    }
}
