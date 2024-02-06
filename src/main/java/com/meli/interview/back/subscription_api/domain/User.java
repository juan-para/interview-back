package com.meli.interview.back.subscription_api.domain;

import com.meli.interview.back.subscription_api.domain.interfaces.FriendshipRepository;
import com.meli.interview.back.subscription_api.domain.interfaces.SubscriptionRepository;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@Builder
public class User {
    private String id;
    private String name;
    @Autowired
    SubscriptionRepository subscriptionRepository;
    @Autowired
    private FriendshipRepository friendshipRepository;


    public List<Subscription> subscriptions() {
        return subscriptionRepository.findSubscriptionsByUser(this);
    }
    public void addSubscription(Subscription subscription) {
        subscriptionRepository.saveSubscription(subscription);
    }
    public List<User> getFriends() {
        return friendshipRepository.getFriends(this);
    }
    public void addFriend(User friend) {
        friendshipRepository.addFriend(this, friend);
    }
}
