package com.group19.bookstore.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String author;
    @Column
    private String genre;
    @Column
    private Double price;
    @Column
    private String publisher;
    @Column
    private Double rating;
    @Column
    private String name;
    @Column(name = "copies_sold")
    private Integer unitsSold;
    @Column
    private Integer volume;
    @Column
    private String isbn;
    @Column(name = "year_published")
    private LocalDate yearPublished;
    @Column
    private String description;

    public Integer getId() {
        return id;
    }

    public Book setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public Book setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public Book setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public Double getRating() {
        return rating;
    }

    public Book setRating(Double rating) {
        this.rating = rating;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Book setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Integer getUnitsSold() {
        return unitsSold;
    }

    public Book setUnitsSold(Integer unitsSold) {
        this.unitsSold = unitsSold;
        return this;
    }

    public Integer getVolume() {
        return volume;
    }

    public Book setVolume(Integer volume) {
        this.volume = volume;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public LocalDate getYearPublished() {
        return yearPublished;
    }

    public Book setYearPublished(LocalDate yearPublished) {
        this.yearPublished = yearPublished;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }
}
