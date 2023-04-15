package com.group19.bookstore.repository;

import com.group19.bookstore.models.Wishlist;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {

    Optional<Wishlist> findByUser_IdAndName(Integer id, String name);

}
