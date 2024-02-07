package com.meli.interview.back.subscription_api.infrastructure;

import com.meli.interview.back.subscription_api.domain.Subscription;
import com.meli.interview.back.subscription_api.domain.interfaces.ISubscriptionRepository;
import com.meli.interview.back.subscription_api.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SubscriptionRepository implements ISubscriptionRepository {

    private final List<Subscription> subscriptionsList = new ArrayList<>();

    @Override
    public List<Subscription> findSubscriptionsByUser(User user) {
        return new ArrayList<>();
    }

    @Override
    public void saveSubscription(Subscription subscription) {
        subscriptionsList.add(subscription);
    }
}