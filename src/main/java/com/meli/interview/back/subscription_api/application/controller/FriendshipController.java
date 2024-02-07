package com.meli.interview.back.subscription_api.application.controller;

import com.meli.interview.back.subscription_api.application.service.FriendshipService;
import com.meli.interview.back.subscription_api.domain.User;
import com.meli.interview.back.subscription_api.infrastructure.FriendshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FriendshipController {

    @Autowired
    private FriendshipService friendshipService;
    @Autowired
    private FriendshipRepository friendshipRepository;

    @PostMapping("/addFriend")
    @ResponseBody
    public String addFriend(
            @RequestParam String userId,
            @RequestParam String friendId) {
        User user = User.builder()
                .id("1")
                .name("Anibal")
                .build();
        User friend = User.builder()
                .id("2")
                .name("Canibal")
                .build();
        friendshipRepository.addFriend(user, friend);
        return "Friend added successfully";
    }

    @GetMapping("/friends")
    @ResponseBody
    public List<User> getUserFriends(
            @RequestParam String userId) {
        User user = User.builder()
                .id("1")
                .name("DummyUser")
                .build();
        return friendshipService.getFriends(user);
    }
}
