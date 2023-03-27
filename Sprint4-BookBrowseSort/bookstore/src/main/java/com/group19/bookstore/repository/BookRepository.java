package com.group19.bookstore.repository;

import com.group19.bookstore.models.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository <Book, Integer> {
    public List<Book> findBooksByGenre(String genre);
    public List<Book> findBooksByRating(Double rating);
    public List<Book> findTopSellingBooks();
    public List<Book> findDiscount();
}
