package com.group19.bookstore.controller;

import com.group19.bookstore.models.Comments;
import com.group19.bookstore.models.Rating;
import com.group19.bookstore.repository.RatingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.group19.bookstore.repository.CommentsRepo;
import com.group19.bookstore.service.CommentAndRatingService;

import java.util.List;


@RestController
public class BookRatingAndCommentingController {
    @Autowired
    private CommentsRepo CommentsRepo;
    @Autowired
    private CommentAndRatingService CommentAndRatingService;

    @Autowired
    private RatingsRepo RatingsRepo;

    @GetMapping(value = "/")
    public String GetPage() {
        return "Welcome";
    }

    @GetMapping(value = "/Allcomments")
    public List<Comments> getComments() {
        return CommentsRepo.findAll();
    }

    @PostMapping(value = ("/SavedComments"))
    public String saveComment(@RequestBody Comments comments) {
        CommentsRepo.save(comments);
        return "Saved";
    }
    @PostMapping(value = ("/NewRating"))
    public String saveRating(@RequestBody Rating rating) {
        RatingsRepo.save(rating);
        return "Saved";
    }

    @GetMapping(value = "/AllRatings")
    public List<Rating> getRating() {
        return RatingsRepo.findAll();
    }

    @GetMapping(value = "/AvgRatings")
    public List<Rating> getAvgRating() {
        return RatingsRepo.findAll();
    }

    @GetMapping ("/Comments/{bookID}")
    public List<Comments> getCommentsByBookID(@PathVariable("bookID")String bookID){
        return CommentAndRatingService.getCommentsByBookID(bookID);
    }

}
