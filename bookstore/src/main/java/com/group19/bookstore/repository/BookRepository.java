package com.group19.bookstore.repository;

import com.group19.bookstore.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository  extends JpaRepository <Book, String> {
    //retrieve List of Books by Genre
    List<Book> findBooksByGenre(String genre);
    //retrieve List of Books for a particular rating and higher
    List<Book> findByRatingGreaterThanEqualOrderByRatingAsc(double rating);
    //publisher discounts
    List<Book> findByPublisher(String publisher);
    //retrieve the top 10 books by copies sold.
    List<Book> findTop10ByOrderByUnitsSoldDesc();
    
    //Check to see if publisher applied discount
    List<Book> findBooksByPublisher(String publisher);
}
