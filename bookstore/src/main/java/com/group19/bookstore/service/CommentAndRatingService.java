package com.group19.bookstore.service;

import com.group19.bookstore.models.Book;
import com.group19.bookstore.models.Comments;
import com.group19.bookstore.models.Rating;
import com.group19.bookstore.repository.CommentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentAndRatingService {
    @Autowired
    private CommentsRepo CommentsRepo;
        public List<Comments> getCommentsByBookID(String bookID) {
            return CommentsRepo.findCommentsByBookID(bookID);
        }
        //public Double avg();

}
