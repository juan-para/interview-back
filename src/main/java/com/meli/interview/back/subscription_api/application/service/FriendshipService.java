package com.meli.interview.back.subscription_api.application.service;

import com.meli.interview.back.subscription_api.domain.User;
import com.meli.interview.back.subscription_api.domain.interfaces.IFriendshipService;
import com.meli.interview.back.subscription_api.exception.UserNotLoggedInException;
import com.meli.interview.back.subscription_api.infrastructure.FriendshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendshipService implements IFriendshipService {

    @Autowired
    FriendshipRepository friendshipRepository;
    @Autowired
    UserService userService;

    @Override
    public List<User> getFriends(String userId) {
        return friendshipRepository.getFriends(userId);
    }

    @Override
    public void addFriend(String userId, String friendId) {
        // Asumo que el amigo del usuario ya existe
        User friend = userService.getUserById(friendId);
        if(!userId.equals(friendId)){
            friendshipRepository.addFriend(userId, friend);
        } else {
            throw new RuntimeException("No te puedes agregar como amigo");
        }
    }
}
