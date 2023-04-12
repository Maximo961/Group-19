package com.group19.bookstore.repository;

import com.group19.bookstore.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, String> {

    /**
     * Retrieves an author by its authorId
     *
     * @param id the requested authorId
     * @return the author that matches the id
     */
    Author findById(Integer id);

    /**
     * Retrieves an author by their name
     *
     * @param name the name of the author
     * @return the author that matches the name
     */
    Author findByName(String name);
}
