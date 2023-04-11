package com.group19.bookstore.repository;

import com.group19.bookstore.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
    //retrieve List of Books by Genre
    List<Book> findBooksByGenre(String genre);
    //retrieve List of Books for a particular rating and higher
    List<Book> findByRatingGreaterThanEqualOrderByRatingAsc(double rating);
    //publisher discounts
    List<Book> findByPublisher(String publisher);
    //retrieve the top 10 books by copies sold.
    List<Book> findTop10ByOrderByUnitsSoldDesc();

    /**
     * Retrieves a book by its isbn.
     *
     * @param isbn the requested isbn
     * @return the book that matches the requested isbn
     */
    Book findBookByIsbn(String isbn);

    /**
     * Retrieves a list of books by author's name
     *
     * @param author the author's name
     * @return a list of books written by the requested author
     */
    List<Book> findBooksByAuthor(String author);
}
