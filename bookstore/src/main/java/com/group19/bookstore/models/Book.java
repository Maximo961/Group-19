package com.group19.bookstore.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Book {

    private Integer id;
    private String author;
    private String genre;
    private Double price;
    private String publisher;
    private Double rating;
    private String title;
    private Integer unitsSold;
    private Integer volume;
    private String isbn;

    public Book setId(Integer id) {
        this.id = id;
        return this;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Book setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public Book setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public Book setRating(Double rating) {
        this.rating = rating;
        return this;
    }

    public Book setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Book setUnitsSold(Integer unitsSold) {
        this.unitsSold = unitsSold;
        return this;
    }

    public Book setVolume(Integer volume) {
        this.volume = volume;
        return this;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }


}
