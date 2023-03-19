package com.group19.bookstore.controller.impl;

import com.group19.bookstore.controller.BrowserController;
import com.group19.bookstore.models.Book;
import com.group19.bookstore.repository.DummyBookStoreRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class BrowsingControllerImpl implements BrowserController {

    @Override
    public List<Book> getBooksByGenre(String genre) {
        return DummyBookStoreRepository.getInstance().getBooks();
    }

    @Override
    public List<Book> getBooksByRating(Double rating) {
        return DummyBookStoreRepository.getInstance().getBooks();
    }

    @Override
    public List<Book> getTopSellingBooks() {
        return DummyBookStoreRepository.getInstance().getBooks();
    }

    @Override
    public void discountPublisher(String genre, Double percent) {
        System.out.println("Genre " + genre + " and percent " + percent);
    }
}
