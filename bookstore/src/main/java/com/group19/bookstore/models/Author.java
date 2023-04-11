package com.group19.bookstore.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    private String biography;
    private String publisher;

    public Integer getId() {
        return id;
    }

    public Author setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Author setName(String name) {
        this.name = name;
        return this;
    }

    public String getBiography() {
        return biography;
    }

    public Author setBiography(String biography) {
        this.biography = biography;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public Author setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }
}
