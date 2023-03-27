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
    private Double discount;


    public Integer getId() {
        return id;
    }
    public void setId (Integer id){
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {return price;}
    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Double getRating(){
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getunitsSold() {
        return unitsSold;
    }
    public void setunitsSold(int unitsSold) {
        this.unitsSold = unitsSold;
    }

    public Double getDiscount() {return discount;}
    public void setDiscount(Double discount) {this.discount = discount;}

}
