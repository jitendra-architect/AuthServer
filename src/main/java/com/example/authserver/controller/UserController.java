package com.example.authserver.controller;

import com.example.authserver.entity.UserCredential;
import com.example.authserver.repository.UserCredentialRepository;
import com.example.authserver.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthService userService;

    @Autowired
    private UserCredentialRepository userRepository;

    @GetMapping("/hi")
    public ResponseEntity<String> hi() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return ResponseEntity.ok("Hi " + username);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserCredential user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
//        User userInDb = userService.findByUserName(userName);
//        userInDb.setUsername(user.getUsername());
//        userInDb.setPassword(user.getPassword());
//        userService.saveNewUser(userInDb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserById() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //userRepository.deleteById(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> greeting() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return new ResponseEntity<>("Hi " + authentication.getName(), HttpStatus.OK);
    }
}