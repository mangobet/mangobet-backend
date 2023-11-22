package org.ignisus.mangobetbackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserBrandController {
    @GetMapping("/{brand}")
    public String brand(@PathVariable String brand) {
        return "brand";
    }

    
}
