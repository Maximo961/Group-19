package com.group19.bookstore.repository;

import com.group19.bookstore.models.Comments;
import com.group19.bookstore.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingsRepo extends JpaRepository<Rating, Double> {
    //List<Rating> getRatingByRatingStartingWith(Double rating);
//    @Query(value = "SELECT avg(rating) FROM bookID")
//    public Double avg();

}
