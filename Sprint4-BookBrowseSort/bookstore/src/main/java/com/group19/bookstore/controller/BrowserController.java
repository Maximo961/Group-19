package com.group19.bookstore.controller;

import com.group19.bookstore.models.Book;
import com.group19.bookstore.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/browse")
public class BrowserController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/genre/{genre}")
    public ResponseEntity <List<Book>> getBooksByGenre(@PathVariable ("genre") String genre) {
        List<Book> books = bookRepository.findBooksByGenre(genre);
        return new ResponseEntity <> (books, HttpStatus.OK);
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity <List<Book>> getBooksByRating(@PathVariable ("rating") Double rating) {
        List<Book> books = bookRepository.findBooksByRating(rating);
        return (ResponseEntity<List<Book>>) this.bookRepository.findBooksByRating(rating);
    }
    @GetMapping("/top-sellers")
    public ResponseEntity <List<Book>> getTopSellingBooks(){
        List<Book> books = bookRepository.findTopSellingBooks();
        return (ResponseEntity<List<Book>>) this.bookRepository.findTopSellingBooks();
    }

    @PutMapping("/discount")
    public ResponseEntity <List<Book>> getDiscount (@PathVariable Double discount){
        List<Book> books = bookRepository.findDiscount();
        return (ResponseEntity<List<Book>>) this.bookRepository.findDiscount();
    }

}
