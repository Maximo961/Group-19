package com.group19.bookstore.controller.impl;

import java.net.URI;
import org.springframework.beans
        .factory.annotation.Autowired;
import org.springframework.http
        .ResponseEntity;
import org.springframework.web.bind
        .annotation.GetMapping;
import org.springframework.web.bind
        .annotation.PostMapping;
import org.springframework.web.bind
        .annotation.RequestBody;
import org.springframework.web.bind
        .annotation.RequestMapping;
import org.springframework.web.bind
        .annotation.RestController;
import org.springframework.web.servlet
        .support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PathVariable;

// Importing the models from the models folder
//Importing the data access object
import com.group19.bookstore.dao.impl.ProfileManagementDaoImpl;
import com.group19.bookstore.models.ProfileManagement;
import com.group19.bookstore.models.Profile;

// Creating the REST controller
@RestController
@RequestMapping(path = "/profiles")
public class ProfileManagementController {

    @Autowired
    private ProfileManagementDaoImpl profileDao;

    // Implementing a GET method
    // to get the list of all
    // the profiles
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

    // Create a POST method
    // to add an profile
    // to the list
    @PostMapping(
            path = "",
            consumes = "application/json",
            produces = "application/json")

    public ResponseEntity<Object> addProfile(
            @RequestBody Profile profile)
    {
        profileDao
                .addProfile(profile);

        URI location
                = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(
                        profile.getUsername())
                .toUri();

        return ResponseEntity
                .created(location)
                .build();
    }
}