package com.example.springbootdemo.api.controller;

import com.example.springbootdemo.dto.CreateUserDTO;
import com.example.springbootdemo.dto.ResponseUserDTO;
import com.example.springbootdemo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.springbootdemo.api.model.User;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addUser(@Valid @RequestBody CreateUserDTO createUserDTO) {
        User newUser = new User(
            userService.generateID(),
            createUserDTO.getName(),
            createUserDTO.getAge(),
            createUserDTO.getEmail(),
            createUserDTO.getPassword()
        );

        return userService.addUser(newUser);
    }

    @GetMapping
    public List<ResponseUserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseUserDTO getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }
}
