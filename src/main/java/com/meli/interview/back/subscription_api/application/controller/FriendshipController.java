package com.meli.interview.back.subscription_api.application.controller;

import com.meli.interview.back.subscription_api.application.controller.request.CreateUserRequest;
import com.meli.interview.back.subscription_api.application.controller.request.FriendshipRequest;
import com.meli.interview.back.subscription_api.application.controller.response.UserFriendsResponse;
import com.meli.interview.back.subscription_api.application.service.FriendshipService;
import com.meli.interview.back.subscription_api.domain.User;
import com.meli.interview.back.subscription_api.infrastructure.FriendshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class FriendshipController {

    @Autowired
    private FriendshipService friendshipService;

    @PostMapping("/addFriend")
    @ResponseBody
    public ResponseEntity<String> addFriend(@Valid @RequestBody FriendshipRequest request) {
        try{
            friendshipService.addFriend(request.getUserId(), request.getFriendId());
            return ResponseEntity.ok("Friend added successfully");
        } catch (RuntimeException e){
            return ResponseEntity.status(400).body("No te puedes agregar como amigo");
        }

    }

    @GetMapping("/friends")
    @ResponseBody
    public UserFriendsResponse getUserFriends( @RequestParam String userId) {
        //return friendshipService.getFriends(userId);
        UserFriendsResponse response = UserFriendsResponse.builder()
        .userId(userId)
        .friends(friendshipService.getFriends(userId))
        .build();
        return response;
    }
}
