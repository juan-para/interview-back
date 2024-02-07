package com.meli.interview.back.subscription_api.application.service;

import com.meli.interview.back.subscription_api.domain.Subscription;
import com.meli.interview.back.subscription_api.domain.User;
import com.meli.interview.back.subscription_api.domain.interfaces.IUserService;
import com.meli.interview.back.subscription_api.infrastructure.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(String userName) {
        User newUser = User.builder()
                .id(Instant.now().toString())
                .name(userName)
                .build();
        return newUser;
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findUserById(id);
    }

    @Override
    public void addSubscriptionByUser(String userId, Subscription subscription) {
        userRepository.addSubscriptionToUser(userId, subscription);
    }
}