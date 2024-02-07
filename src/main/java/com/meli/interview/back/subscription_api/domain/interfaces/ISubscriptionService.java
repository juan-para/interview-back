package com.meli.interview.back.subscription_api.domain.interfaces;

import com.meli.interview.back.subscription_api.domain.Subscription;
import com.meli.interview.back.subscription_api.domain.User;

import java.util.ArrayList;

public interface ISubscriptionService {
    float getUserSubscriptionsCost(User user);

    ArrayList<Subscription> findSubscriptionByUserId(String id);
}