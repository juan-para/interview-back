package com.meli.interview.back.subscription_api.application.controller;

import com.meli.interview.back.subscription_api.application.controller.request.CreateUserRequest;
import com.meli.interview.back.subscription_api.application.service.UserService;
import com.meli.interview.back.subscription_api.domain.User;
import com.meli.interview.back.subscription_api.domain.interfaces.IUserRepository;
import com.meli.interview.back.subscription_api.domain.interfaces.IUserService;
import com.meli.interview.back.subscription_api.infrastructure.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/createUser")
    @ResponseBody
    public ResponseEntity<String> createUser(@Valid @RequestBody CreateUserRequest request) {
        // Se podria hacer de manera asincornica o implementando topicos
        User newUser = userService.createUser(request.getUserName());
        userRepository.saveUser(newUser);
        return ResponseEntity.ok( "Usuario creado exitosamente: " + userRepository.findUserById(newUser.getId()));
    }
}