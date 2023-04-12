package com.group19.bookstore.controller.impl;

import com.group19.bookstore.controller.BookDetailsController;
import com.group19.bookstore.controller.requests.AuthorRequestBody;
import com.group19.bookstore.controller.requests.BookRequestBody;
import com.group19.bookstore.models.Author;
import com.group19.bookstore.models.Book;
import com.group19.bookstore.models.User;
import com.group19.bookstore.repository.AuthorRepository;
import com.group19.bookstore.repository.BookRepository;
import com.group19.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
public class BookDetailsControllerImpl implements BookDetailsController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final UserRepository userRepository;

    @Autowired
    public BookDetailsControllerImpl(
            final BookRepository bookRepository,
            final AuthorRepository authorRepository,
            final UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.userRepository = userRepository;
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
    public void addAuthor(AuthorRequestBody authorRequestBody, String username, String password) {
        validateUserCredentialsHaveAdmin(username, password);

        // Look up author to be sure they do not already exist.
        Author possiblyExistingAuthor = authorRepository.findByName(concatAuthorNames(authorRequestBody));

        // If the author doesn't exist, add it.
        if (possiblyExistingAuthor == null) {
            Author newAuthor = mapRequestToAuthor(authorRequestBody);
            authorRepository.save(newAuthor);
        }
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        Book book = bookRepository.findBookByIsbn(isbn);

        if (book == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Could not find book for given isbn: " + isbn
            );
        }

        return book;
    }

    @Override
    public void addBook(BookRequestBody bookRequestBody, String username, String password) {
        validateUserCredentialsHaveAdmin(username, password);

        Book possiblyExistingBook = bookRepository.findBookByName(bookRequestBody.getName());

        if (possiblyExistingBook == null) {

            Author possiblyExistingAuthor = authorRepository.findByName(bookRequestBody.getAuthor());

            if (possiblyExistingAuthor == null) {
                Author newAuthor = new Author()
                        .setName(bookRequestBody.getAuthor())
                        .setBiography("")
                        .setPublisher(bookRequestBody.getPublisher());
                authorRepository.save(newAuthor);
            }

            Book newBook = mapRequestToBook(bookRequestBody);
            bookRepository.save(newBook);
        }
    }

    private void validateUserCredentialsHaveAdmin(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);

        // If user credentials do not exist, return unauthorized.
        if (user == null) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Could not find a user with " + username
            );
        }

        // Validate the user is an admin.
        boolean isAdmin = Boolean.parseBoolean(user.getAdmin());
        if (!isAdmin) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "This user does not have admin rights " + username
            );
        }
    }

    private Author mapRequestToAuthor(AuthorRequestBody authorRequestBody) {
        return new Author()
                .setName(concatAuthorNames(authorRequestBody))
                .setPublisher(authorRequestBody.getPublisher())
                .setBiography(authorRequestBody.getBiography());
    }

    private Book mapRequestToBook(BookRequestBody bookRequestBody) {
        return new Book()
                .setIsbn(bookRequestBody.getIsbn())
                .setName(bookRequestBody.getName())
                .setDescription(bookRequestBody.getDescription())
                .setPrice(bookRequestBody.getPrice())
                .setAuthor(bookRequestBody.getAuthor())
                .setGenre(bookRequestBody.getGenre())
                .setPublisher(bookRequestBody.getPublisher())
                .setYearPublished(LocalDate.ofYearDay(bookRequestBody.getYearPublished(), 1))
                .setUnitsSold(bookRequestBody.getCopiesSold());
    }

    private String concatAuthorNames(AuthorRequestBody authorRequestBody) {
        return String.format("%s %s", authorRequestBody.getFirstName(), authorRequestBody.getLastName());
    }
}
