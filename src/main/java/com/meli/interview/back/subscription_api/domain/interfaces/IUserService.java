package com.meli.interview.back.subscription_api.domain.interfaces;

import com.meli.interview.back.subscription_api.domain.Subscription;
import com.meli.interview.back.subscription_api.domain.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User createUser(String userName);
    User getUserById(String id);
    void addSubscriptionByUser(String userId, Subscription subscription);
}