package com.meli.interview.back.subscription_api.application.controller;

import com.meli.interview.back.subscription_api.application.service.SubscriptionService;
import com.meli.interview.back.subscription_api.application.service.UserService;
import com.meli.interview.back.subscription_api.domain.Partner;
import com.meli.interview.back.subscription_api.domain.Subscription;
import com.meli.interview.back.subscription_api.domain.User;
import com.meli.interview.back.subscription_api.infrastructure.SubscriptionRepository;
import com.meli.interview.back.subscription_api.infrastructure.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private UserService userService;
    @Autowired
    private SubscriptionRepository subscriptionRepository;


    @PostMapping("/subscribe")
    @ResponseBody
    public String subscribe(
            @RequestBody String userId,
            @RequestBody String partner) {
        Subscription subscription = Subscription.builder()
                .partner(Partner.valueOf(partner))
                .build();
        userService.addSubscriptionByUser(userId, subscription);
        return "Subscribed successfully";
    }

    @GetMapping("/subscriptions")
    @ResponseBody
    public List<Subscription> getUserSubscriptions(
            @RequestParam String userId) {
        return subscriptionService.findSubscriptionByUserId(userId);
    }
}