package com.meli.interview.back.subscription_api.application.service;

import com.meli.interview.back.subscription_api.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User createUser(String userId, String userName) {
        // Lógica para crear un nuevo usuario
        User newUser = new User(userId, userName);
        // Puedes realizar otras operaciones según tus necesidades...
        return newUser;
    }
}