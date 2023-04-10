package com.group19.bookstore.models;

import java.util.ArrayList;
import java.util.List;

// Class to store the list of
// all the employees in an
// Array List
public class ProfileManagement {

    private List<Profile> profileList;

    // Method to return the list
    // of employees
    public List<Profile> getProfileList()
    {

        if (profileList == null) {

            profileList
                    = new ArrayList<>();


        }

        return profileList;


    }

    public void
    setProfileList(
            List<Profile> profileList)
    {
        this.profileList
                = profileList;
    }
}