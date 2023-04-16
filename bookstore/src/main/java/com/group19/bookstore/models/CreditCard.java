package com.group19.bookstore.models;

// Creating a Credit Card object
public class CreditCard {

    public CreditCard() {}

    private String username;
    private String name;
    private String credit_card_number;
    private String expiration;
    private String security_code;

    // Constructor to add all properties to local variables
    public CreditCard(
            String username, String name,
            String credit_card_number, String expiration, String security_code)
    {
        this.username = username;
        this.name = name;
        this.credit_card_number = credit_card_number;
        this.expiration = expiration;
        this.security_code = security_code;
    }

    // Overriding the toString method to find all the values
    @Override
    public String toString()
    {

        return "CreditCard [username="
                + username + ", name="
                + name + ", credit_card_number="
                + credit_card_number + ", expiration="
                + expiration + ", security_code="
                + security_code + "]";


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

    public String getName()
    {

        return name;
    }

    public void setName(
            String name)
    {

        this.name = name;
    }

    public String getCreditCardNumber()
    {

        return credit_card_number;
    }

    public void setCreditCardNumber(
            String credit_card_number)
    {

        this.credit_card_number = credit_card_number;
    }

    public String getExpiration()
    {

        return expiration;
    }

    public void setExpiration(String expiration)
    {

        this.expiration = expiration;
    }

    public String getSecurityCode()
    {

        return security_code;
    }

    public void setSecurityCode(String security_code)
    {

        this.security_code = security_code;
    }
}