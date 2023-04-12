package com.group19.bookstore.repository;

import com.group19.bookstore.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    /**
     * Retrieves a user by their username and password
     *
     * @param username the requested username
     * @param password the requested password
     * @return the user that matches the username and password
     */
    User findByUsernameAndPassword(String username, String password);
}
