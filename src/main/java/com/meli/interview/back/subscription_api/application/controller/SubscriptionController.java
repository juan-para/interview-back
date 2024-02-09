package com.meli.interview.back.subscription_api.application.controller;

import com.meli.interview.back.subscription_api.application.controller.request.SubscriptionRequest;
import com.meli.interview.back.subscription_api.application.service.SubscriptionService;
import com.meli.interview.back.subscription_api.application.service.UserService;
import com.meli.interview.back.subscription_api.domain.Partner;
import com.meli.interview.back.subscription_api.domain.Subscription;
import com.meli.interview.back.subscription_api.domain.User;
import com.meli.interview.back.subscription_api.infrastructure.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.meli.interview.back.subscription_api.exception.UserNotLoggedInException;

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
    public ResponseEntity<String> subscribe(@RequestBody SubscriptionRequest request) {
        Subscription subscription = Subscription.builder()
                .partner(Partner.valueOf(request.getPartner()))
                .build();
        userService.addSubscriptionByUser(request.getUserId(), subscription);
        return ResponseEntity.ok("Subscribed successfully");
    }

    @GetMapping("/subscriptions")
    @ResponseBody
    public List<Subscription> getUserSubscriptions(
            @RequestParam String userId) {
        return subscriptionService.findSubscriptionByUserId(userId);
    }

    @GetMapping("/subscriptionCost")
    @ResponseBody
    public ResponseEntity<String> getUserSubscriptionCost(@RequestParam String userId) {
        try {
            User user = userService.getUserById(userId);
            if(user != null){
                Float subscriptionCost = subscriptionService.getUserSubscriptionsCost(userService.getUserById(userId));
                return ResponseEntity.ok("Total cost: "+ subscriptionCost);
            } else {
                return ResponseEntity.status(404).body("User Not Found");
            }
        } catch (UserNotLoggedInException e) {
            return ResponseEntity.status(401).body("User Not Logged In.");
        }
    }
}