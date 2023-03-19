package com.group19.bookstore.controller;

import com.group19.bookstore.models.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/api/browse")
public interface BrowserController {

    @GetMapping(value = "/genre/{genre}", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    List<Book> getBooksByGenre(@PathVariable String genre);

    @GetMapping(value = "/rating/{rating}", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    List<Book> getBooksByRating(@PathVariable Double rating);

    @GetMapping(value = "/top-sellers", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    List<Book> getTopSellingBooks();

    @PutMapping(value = "/discount", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    void discountPublisher(@RequestParam String genre, @RequestParam Double percent);
}
