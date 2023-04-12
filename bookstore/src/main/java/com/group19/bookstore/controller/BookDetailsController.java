package com.group19.bookstore.controller;

import com.group19.bookstore.controller.requests.AuthorRequestBody;
import com.group19.bookstore.controller.requests.BookRequestBody;
import com.group19.bookstore.models.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/api/book-details")
public interface BookDetailsController {
    @GetMapping(value = "/author/{authorId}", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    List<Book> getBooksByAuthorId(@PathVariable String authorId);

    @PostMapping(value = "/author")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void addAuthor(@RequestBody AuthorRequestBody authorRequestBody, @RequestHeader String username, @RequestHeader String password);

    @GetMapping(value = "/isbn/{isbn}", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    Book getBookByIsbn(@PathVariable String isbn);

    @PostMapping(value = "/book")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void addBook(@RequestBody BookRequestBody bookRequestBody, @RequestHeader String username, @RequestHeader String password);

}
