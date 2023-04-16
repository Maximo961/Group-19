package com.group19.bookstore.models;

// Creating a Profile object
public class Profile {

    public Profile() {}

    private String username;
    private String password;
    private String name;
    private String email;
    private String homeAddress;


    // Constructor to add all properties to local variables
    public Profile(
            String username, String password,
            String name, String email, String homeAddress)
    {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.homeAddress = homeAddress;
    }

    // Overriding the toString method to find all the values
    @Override
    public String toString()
    {

        return "Profile [username="
                + username + ", password="
                + password + ", name="
                + name + ", email="
                + email + ", homeAddress="
                + homeAddress + "]";


    }

    // Getters and setters of
    // the properties
    public String getUsername()
    {

        return username;
    }

    public void setUsername(String username)
    {

        this.username = username;
    }

    public String getPassword()
    {

        return password;
    }

    public void setPassword(
            String password)
    {

        this.password = password;
    }

    public String getName()
    {

        return name;
    }

    public void setName(
            String name)
    {

        this.name = name;
    }

    public String getEmail()
    {

        return email;
    }

    public void setEmail(String email)
    {

        this.email = email;
    }

    public String getHomeAddress()
    {

        return homeAddress;
    }

    public void setHomeAddress(String homeAddress)
    {

        this.homeAddress = homeAddress;
    }
}