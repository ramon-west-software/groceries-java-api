package com.ramonwest.groceriesapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class HomeControler {
    @GetMapping("/")
    public ResponseEntity<String> getWelcome() {
        return new ResponseEntity<>("Welcome!", HttpStatus.OK);
    }
}
