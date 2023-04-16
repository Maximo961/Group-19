package com.group19.bookstore.repository;

import com.group19.bookstore.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Pricerepo extends JpaRepository<Price, Long> {
    List<Price> findPriceByUsername(long username);
}
