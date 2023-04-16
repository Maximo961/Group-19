package com.group19.bookstore.repository;

import com.group19.bookstore.models.Cart;
import com.group19.bookstore.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Cartrepo extends JpaRepository<Cart,Long> {
    List<Cart> findPriceByUsername(long username);
}
