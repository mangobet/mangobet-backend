package org.ignisus.mangobetbackend.controllers;


import org.ignisus.mangobetbackend.classes.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/user")
public class UserController {
    public UserController() {
        new User();
    }

    @GetMapping("/welcome/{userName}")
    public String welcomeUser(@PathVariable String userName) {
        return "Welcome " + userName;
    }
    public String registerUser(User user) {
        user.printUser();
        return "User registered";
    }
    @PostMapping(consumes = {"application/json", "application/xml"})
    public ResponseEntity<String> createUser(@RequestBody User user) {

        user.printUser();
        return ResponseEntity.ok("Usuario creado con éxito");
    }

    
}
