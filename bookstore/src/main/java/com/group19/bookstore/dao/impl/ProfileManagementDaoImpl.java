package com.group19.bookstore.dao.impl;

import org.springframework
        .stereotype
        .Repository;

import java.sql.*;

// Importing the profile management class to
// use the defined properties
// in this class
import com.group19.bookstore.models.ProfileManagement;
import com.group19.bookstore.models.Profile;
import com.group19.bookstore.models.CreditCard;

import java.util.ArrayList;
import java.util.List;

@Repository

// Class to create a list
// of Profile
public class ProfileManagementDaoImpl {

    private static ProfileManagement profileManagement = new ProfileManagement();
    private List<Profile> profileList;
    private List<CreditCard> creditCardList;

    // ProfileManagementDaoImpl
    public ProfileManagementDaoImpl()
    {
        profileList = profileManagement.getProfileList();
        creditCardList = profileManagement.getCreditCardList();

        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sql_bookinventory",
                    "root", "password");

            // mydb is database
            // mydbuser is name of database
            // mydbuser is password of database

            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            // Place query here
            resultSet = statement.executeQuery(
                    "SELECT * FROM sql_bookinventory.users;");
            String userName;
            String password;
            String name;
            String email;
            String homeAddress;

            while (resultSet.next()) {
                userName = resultSet.getString("username").trim();
                password = resultSet.getString("password").trim();
                name = resultSet.getString("name").trim();
                email = resultSet.getString("email").trim();
                homeAddress = resultSet.getString("home_address").trim();

                profileList.add(
                        new Profile(
                                userName,
                                password,
                                name,
                                email,
                                homeAddress));

            }

            resultSet = statement.executeQuery(
                    "SELECT * FROM sql_bookinventory.credit_card;");
            String credit_card_number;
            String expiration;
            String security_code;

            while (resultSet.next()) {
                userName = resultSet.getString("username").trim();
                name = resultSet.getString("name").trim();
                credit_card_number = resultSet.getString("credit_card_number").trim();
                expiration = resultSet.getString("expiration").trim();
                security_code = resultSet.getString("security_code").trim();

                creditCardList.add(
                        new CreditCard(
                                userName,
                                name,
                                credit_card_number,
                                expiration,
                                security_code));

            }

            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }

    // Method to return the list
    public ProfileManagement getAllProfile()
    {
        return profileManagement;
    }

    // Method to return a user
    public Profile getProfile(String username)
    {
        for (Profile profile : profileList)
        {
            if(profile.getUsername().equals(username))
            {
                return profile;
            }
        }

        return null;
    }

    // Method to add an profile
    // to the ProfileManagement list
    public boolean addProfile(Profile profile)
    {
        if(getProfile(profile.getUsername()) != null)
        {
            return false;
        }

        profileList.add(profile);

        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sql_bookinventory",
                    "root", "password");

            // mydb is database
            // mydbuser is name of database
            // mydbuser is password of database

            Statement statement;
            statement = connection.createStatement();
            int result;
            // Place query here

            String updateString = "INSERT INTO `users` VALUES ('" + profile.getUsername() + "', '" + profile.getPassword()
                    + "', '"+ profile.getName() +"','" + profile.getEmail() +"','" + profile.getHomeAddress() + "')";
            result = statement.executeUpdate(updateString);
        }
        catch (Exception exception) {
            System.out.println(exception);
        }

        return true;
    }

    // Method to update an profile
    // to the ProfileManagement list
    public boolean updateProfile(String userName, Profile profile)
    {
        /* if user == list
            return null; */
        if(getProfile(userName) == null)
        {
            return false;
        }

        int profileIndex = 0;
        for(int i = 0; i < profileList.size(); i++)
        {
            if(userName.equals(profileList.get(i).getUsername()))
            {
                profileIndex = i;
            }
        }

        // overriding the profile list at the specific profile index with the updated details
        profileList.set(profileIndex, profile);

        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sql_bookinventory",
                    "root", "password");

            // mydb is database
            // mydbuser is name of database
            // mydbuser is password of database

            Statement statement;
            statement = connection.createStatement();
            int result;

            String updateString = "UPDATE users\n" +
                    "SET username='" + profile.getUsername() + "', password='"+ profile.getPassword() + "', name='" +
                    profile.getName() + "', email='" + profile.getEmail() + "', home_address='" + profile.getHomeAddress() +
                    "'\nWHERE username='" + userName + "';";

            result = statement.executeUpdate(updateString);
        }
        catch (Exception exception) {
            System.out.println(exception);
        }

        return true;
    }

    // Method to return a user's credit card
    public CreditCard getCreditCard(String username)
    {
        for (CreditCard creditCard : creditCardList)
        {
            if(creditCard.getUsername().equals(username))
            {
                return creditCard;
            }
        }

        return null;
    }

    // Method to add a credit card
    // to the ProfileManagement credit card list
    public boolean addCreditCard(CreditCard creditCard)
    {
        if(getProfile(creditCard.getUsername()) == null)
        {
            return false;
        }

        if(getCreditCard(creditCard.getUsername()) != null)
        {
            return false;
        }

        creditCardList.add(creditCard);

        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sql_bookinventory",
                    "root", "password");

            // mydb is database
            // mydbuser is name of database
            // mydbuser is password of database

            Statement statement;
            statement = connection.createStatement();
            int result;
            // Place query here

            String updateString = "INSERT INTO `credit_card` VALUES ('" + creditCard.getUsername() + "', '" + creditCard.getName()
                    + "', '"+ creditCard.getCreditCardNumber() +"','" + creditCard.getExpiration() +"','" + creditCard.getSecurityCode() + "')";
            result = statement.executeUpdate(updateString);
        }
        catch (Exception exception) {
            System.out.println(exception);
        }

        return true;
    }

}