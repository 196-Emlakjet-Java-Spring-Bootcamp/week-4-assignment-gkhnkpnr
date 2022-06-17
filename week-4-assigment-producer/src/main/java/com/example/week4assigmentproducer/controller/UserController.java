package com.example.week4assigmentproducer.controller;

import com.example.week4assigmentproducer.business.UserService;
import com.example.week4assigmentproducer.dto.UserDTO;
import com.example.week4assigmentproducer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.PrimaryKeyJoinColumn;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void createUser(@RequestBody UserDTO userDTO){
        userService.createUser(userDTO);
    }
}
