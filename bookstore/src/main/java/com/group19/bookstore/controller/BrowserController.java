package com.group19.bookstore.controller;

import com.group19.bookstore.models.Book;
import com.group19.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping ("/api/browse")
public class BrowserController {
    @Autowired
    private BookService bookService;

    @GetMapping ("/genre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable String genre){
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping("/top-sellers")
    public List<Book> getTopSellers() {
        return bookService.getTopSellers();
    }
    @GetMapping("/rating/{rating}")
    public List<Book> getBooksByRatingAscending(@PathVariable double rating) {
        return bookService.getBooksByRatingAscending(rating);
    }
    @PutMapping("/discount/{publisher}/{discountPercent}")
    public String discountBooksByPublisher(@PathVariable String publisher, @PathVariable double discountPercent) {
        bookService.discountBooksByPublisher(publisher, discountPercent);
        return "Discount applied successfully.";
    }
    @GetMapping("/publisher/{publisher}")
    public List<Book> getBooksByPublisher(@PathVariable String publisher){
        return bookService.getBooksByPublisher(publisher);
    }

}
