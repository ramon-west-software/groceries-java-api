package com.ramonwest.groceriesapi.controller;

import com.ramonwest.groceriesapi.data.entity.User;
import com.ramonwest.groceriesapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Fetch user data by user_id
    @GetMapping("/users/{id}")
    public List<User> getUserById(@PathVariable Long id) {
        User user = userService.getUser(id);
        List<User> users = new ArrayList<>();

        if (user != null) {
            users.add(user);

        } else {
            // route to new user sign up / retry login message
//            return new User();
        }
        return users;
    }

    @PostMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@RequestBody User newUser) {
        System.out.println("New User: " + newUser);
        // Process the newUser object
        // todo: make this async, return a bool
        userService.addUser(newUser);

        // If bool == true, Return a success response
        return newUser;
    }


}