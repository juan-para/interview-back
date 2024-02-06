package com.meli.interview.back.subscription_api.domain.interfaces;

import com.meli.interview.back.subscription_api.domain.Subscription;
import com.meli.interview.back.subscription_api.domain.User;

import java.util.List;

public interface SubscriptionRepository {
    List<Subscription> findSubscriptionsByUser(User user);

    void saveSubscription(Subscription subscription);
}