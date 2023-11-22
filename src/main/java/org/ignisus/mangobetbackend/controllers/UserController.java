package org.ignisus.mangobetbackend.controllers;


import org.ignisus.mangobetbackend.classes.User;
import org.ignisus.mangobetbackend.services.UserService;
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
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
}
    @GetMapping("/welcome/{userName}")
    public String welcomeUser(@PathVariable String userName) {
        return "Welcome " + userName;
    }
    public String registerUser(User user) {
        System.out.println(user.toString());
        return "User registered";
    }
    
    @PostMapping(consumes = {"application/json", "application/xml"})
    public User Register(@Valid @RequestBody User user) {
        System.out.println(user.toString());
        return userService.save(user);

    }
    
    @PostMapping(path = "/login", consumes = {"application/json", "application/xml"})
    public org.apache.catalina.User login(@Valid @RequestBody User user) {
        return userService.findByUsername(user.getUsername());
    }

}

