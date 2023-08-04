package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.dtos.Credentials;
import com.db.grad.javaapi.exception.UserAlreadyExistsException;
import com.db.grad.javaapi.exception.UserDoesNotExistException;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody Credentials credentials) {
        return ResponseEntity.ok().body(userService.registerUser(credentials));
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody Credentials credentials) {
        return ResponseEntity.ok().body(userService.loginUser(credentials));
    }

}