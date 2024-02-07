package com.meli.interview.back.subscription_api.domain.interfaces;

import com.meli.interview.back.subscription_api.domain.Subscription;
import com.meli.interview.back.subscription_api.domain.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    Optional<User> findUserById(String id);
    void saveUser(User user);
    void addSubscriptionToUser(String userId, Subscription subscription);
}