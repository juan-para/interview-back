package com.meli.interview.back.subscription_api.infrastructure;

import com.meli.interview.back.subscription_api.domain.Subscription;
import com.meli.interview.back.subscription_api.domain.interfaces.SubscriptionRepository;
import com.meli.interview.back.subscription_api.domain.User;

import java.util.ArrayList;
import java.util.List;

public class InMemorySubscriptionRepository implements SubscriptionRepository {

    private final List<Subscription> subscriptions = new ArrayList<>();

    @Override
    public List<Subscription> findSubscriptionsByUser(User user) {
        return new ArrayList<>();
    }

    @Override
    public void saveSubscription(Subscription subscription) {
        // Implementación para guardar una suscripción
        // ...
    }
}