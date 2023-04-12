package com.group19.bookstore.controller.requests;

public class BookRequestBody {

    private String isbn;
    private String name;
    private String description;
    private Double price;
    private String author;
    private String genre;
    private String publisher;
    private Integer yearPublished;
    private Integer copiesSold;

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    public Integer getCopiesSold() {
        return copiesSold;
    }
}
