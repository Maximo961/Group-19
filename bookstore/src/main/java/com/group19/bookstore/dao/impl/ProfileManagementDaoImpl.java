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

@Repository

// Class to create a list
// of Profile
public class ProfileManagementDaoImpl {

    private static ProfileManagement list
            = new ProfileManagement();

    // This static block is executed
    // before executing the main
    // block
    static
    {
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

                list.getProfileList().add(
                        new Profile(
                                userName,
                                password,
                                name,
                                email,
                                homeAddress));

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
        return list;
    }

    // Method to return a user
    public Profile getProfile(String username)
    {
        for (Profile profile : list.getProfileList())
        {
            if(profile.getUsername().equals(username))
            {
                return profile;
            }
        }

        return null;
    }

    // Method to add an employee
    // to the ProfileManagement list
    public void addProfile(Profile profile)
    {
        list.getProfileList()
                .add(profile);

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
    }
}