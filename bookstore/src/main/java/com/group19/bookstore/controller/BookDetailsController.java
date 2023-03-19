package com.group19.bookstore.controller;

import com.group19.bookstore.models.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/api/book-details")
public interface BookDetailsController {
    @GetMapping(value = "/author/{authorId}", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    List<Book> getBooksByAuthorId(@PathVariable String authorId);

}
