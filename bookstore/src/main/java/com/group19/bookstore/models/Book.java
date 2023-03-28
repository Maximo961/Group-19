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
    private Integer volume;
    private String isbn;
}
