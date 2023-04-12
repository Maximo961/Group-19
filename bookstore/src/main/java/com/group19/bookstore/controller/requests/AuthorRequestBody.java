package com.group19.bookstore.controller.requests;

public class AuthorRequestBody {

    private String firstName;
    private String lastName;
    private String biography;
    private String publisher;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBiography() {
        return biography;
    }

    public String getPublisher() {
        return publisher;
    }
}
