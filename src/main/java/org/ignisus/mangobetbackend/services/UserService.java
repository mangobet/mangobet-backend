package org.ignisus.mangobetbackend.services;

import org.apache.catalina.User;
import org.ignisus.mangobetbackend.repositorys.UserRepository;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class UserService {
    private final UserRepository userRepository;    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public org.ignisus.mangobetbackend.classes.User save(org.ignisus.mangobetbackend.classes.@Valid User user) {
        return null;
    }

    
}
