package com.queuebite.controller;

import com.queuebite.dto.LoginRequest;
import com.queuebite.dto.LoginResponse;
import com.queuebite.dto.UserDTO;
import com.queuebite.model.User;
import com.queuebite.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@Valid @RequestBody UserDTO userDTO) {

        User user = new User();

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());

        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public LoginResponse loginUser(
            @RequestBody LoginRequest request
    ) {
        return userService.loginUser(request);
    }
}