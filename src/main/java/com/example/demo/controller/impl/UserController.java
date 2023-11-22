package com.example.demo.controller.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cart;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/cart")
    public Cart getCart() {
        return new Cart();
    }

    @PostMapping("/cart")
    public void addToCart(@RequestBody Cart cart) {
        // return new Cart();
    }

    @GetMapping()
    public ResponseEntity<String> getUser(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok().body(userDetails.getUsername());
    }
}
