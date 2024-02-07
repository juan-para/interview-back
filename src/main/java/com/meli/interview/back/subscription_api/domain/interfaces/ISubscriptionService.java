package com.meli.interview.back.subscription_api.domain.interfaces;

import com.meli.interview.back.subscription_api.domain.Subscription;
import com.meli.interview.back.subscription_api.domain.User;

import java.util.List;

public interface ISubscriptionService {
    float calculateUserSubscriptionsCost(User user);
    //void addSubscription(Subscription subscription);
    List<Subscription> findSubscriptionByUserId(String id);
}