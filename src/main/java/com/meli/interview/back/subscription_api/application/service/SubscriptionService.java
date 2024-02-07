package com.meli.interview.back.subscription_api.application.service;

import com.meli.interview.back.subscription_api.domain.Subscription;
import com.meli.interview.back.subscription_api.domain.User;
import com.meli.interview.back.subscription_api.domain.interfaces.ISubscriptionService;
import com.meli.interview.back.subscription_api.infrastructure.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService implements ISubscriptionService {


    @Autowired
    private FriendshipService friendshipService;
    @Autowired
    private UserService userService;
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public SubscriptionService(FriendshipService friendshipService) {
        this.friendshipService = friendshipService;
    }

    @Override
    public float calculateUserSubscriptionsCost(User user) {
        return 0.0f;
    }

    @Override
    public List<Subscription> findSubscriptionByUserId(String id) {
        User user = userService.getUserById(id).get();
        return user.getSubscribedList();
    }
}