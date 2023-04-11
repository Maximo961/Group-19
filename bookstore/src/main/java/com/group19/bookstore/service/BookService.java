package com.group19.bookstore.service;

import com.group19.bookstore.models.Book;
import com.group19.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findBooksByGenre(genre);
    }

    public List<Book> getTopSellers() {
        return bookRepository.findTop10ByOrderByUnitsSoldDesc();
    }

    public List<Book> getBooksByRatingAscending(double rating) {
        return bookRepository.findByRatingGreaterThanEqualOrderByRatingAsc(rating);
    }

    public void discountBooksByPublisher(String publisher, double discountPercent) {
        List<Book> books = bookRepository.findByPublisher(publisher);
        for (Book book : books) {
            double newPrice = book.getPrice() * (1 - discountPercent);
            book.setPrice(newPrice);
            bookRepository.save(book);
        }
    }
    
    public List<Book> getBooksByPublisher(String publisher) {
        return bookRepository.findBooksByPublisher(publisher);
    }
    
}
