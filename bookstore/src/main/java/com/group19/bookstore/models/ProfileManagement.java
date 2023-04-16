package com.group19.bookstore.models;

import java.util.ArrayList;
import java.util.List;

// Class to store the list of all the profiles in an Array List
public class ProfileManagement {

    private List<Profile> profileList;
    private List<CreditCard> creditCardList;

    // Method to return the list of profiles
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

    // Method to return the list of credit cards
    public List<CreditCard> getCreditCardList()
    {
        if (creditCardList == null) {
            creditCardList
                    = new ArrayList<>();
        }
        return creditCardList;
    }

    public void
    setCreditCardList(
            List<CreditCard> creditCardList)
    {
        this.creditCardList
                = creditCardList;
    }
}