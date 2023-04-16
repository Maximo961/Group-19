package com.group19.bookstore.controller.impl;

import java.net.URI;
import org.springframework.beans
        .factory.annotation.Autowired;
import org.springframework.http
        .ResponseEntity;
import org.springframework.web.bind
        .annotation.*;
import org.springframework.web.servlet
        .support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PathVariable;

// Importing the models from the models folder
//Importing the data access object
import com.group19.bookstore.dao.impl.ProfileManagementDaoImpl;
import com.group19.bookstore.models.ProfileManagement;
import com.group19.bookstore.models.Profile;
import com.group19.bookstore.models.CreditCard;

// Creating the REST controller
@RestController
@RequestMapping(path = "/profiles")
public class ProfileManagementController {

    @Autowired
    private ProfileManagementDaoImpl profileDao;

    // Implementing a GET method to get the list of all the profiles
    @GetMapping(
            path = "",
            produces = "application/json")

    public ProfileManagement getProfiles()
    {
        return profileDao
                .getAllProfile();
    }

    @GetMapping(path = "/{username}", produces = "application/json")
    public Profile getProfile(@PathVariable("username") String username)
    {
        return profileDao
                .getProfile(username);
    }

    // Create a POST method to add an profile
    @PostMapping(
            path = "",
            consumes = "application/json",
            produces = "application/json")

    public ResponseEntity<Object> addProfile(
            @RequestBody Profile profile)
    {
        boolean addedProfile = profileDao.addProfile(profile);

        URI location
                = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(
                        profile.getUsername())
                .toUri();

        if (addedProfile == false)
        {
            return ResponseEntity
                    .badRequest()
                    .body("Profile could not be added. Profile may already exist.");
        }

        return ResponseEntity
                .created(location)
                .build();
    }

    // Create a PUT method to update a profile
    @PutMapping(
            path = "/{username}",
            consumes = "application/json",
            produces = "application/json")

    public ResponseEntity<Object> updateProfile(
            @RequestBody Profile profile, @PathVariable("username") String username)
    {
        boolean updatedProfile = profileDao.updateProfile(username, profile);

        URI location
                = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(
                        profile.getUsername())
                .toUri();

        if (updatedProfile == false)
        {
            return ResponseEntity
                    .badRequest()
                    .body("Profile could not be updated. Profile may not exist.");
        }

        return ResponseEntity
                .ok()
                .body(location);
    }

    // Create a GET method to get a credit card
    @GetMapping(path = "/{username}/creditcard", produces = "application/json")
    public CreditCard getCreditCard(@PathVariable("username") String username)
    {
        return profileDao.getCreditCard(username);
    }

    // Create a POST method to add a credit card
    @PostMapping(
            path = "/{username}/creditcard",
            consumes = "application/json",
            produces = "application/json")

    public ResponseEntity<Object> addCreditCard(
            @PathVariable("username") String username, @RequestBody CreditCard creditCard)
    {
        boolean addedCreditCard = profileDao.addCreditCard(creditCard);

        URI location
                = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("")
                .buildAndExpand(
                        creditCard.getUsername())
                .toUri();

        if (addedCreditCard == false)
        {
            return ResponseEntity
                    .badRequest()
                    .body("Credit Card could not be added. Credit Card may already exist.");
        }

        return ResponseEntity
                .created(location)
                .build();
    }
}