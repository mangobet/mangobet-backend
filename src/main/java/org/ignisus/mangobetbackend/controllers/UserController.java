package org.ignisus.mangobetbackend.controllers;


import org.ignisus.mangobetbackend.classes.User;
import org.ignisus.mangobetbackend.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jakarta.validation.Valid;


@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/welcome/{username}")    
    public String welcome(@PathVariable String username) {
        return "Welcome " + username + "!";
    }

    @PostMapping(path = "/register")
    public ResponseEntity<User> register(@Valid @RequestBody User user) {
        try {
            User newUser =  userRepository.save(new User(user.getUsername(), user.getPassword(), user.getEmail()));
            return new ResponseEntity<>(newUser, org.springframework.http.HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

