package com.meli.interview.back.subscription_api.application.service;

import com.meli.interview.back.subscription_api.domain.interfaces.FriendshipRepository;
import com.meli.interview.back.subscription_api.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendshipService implements FriendshipRepository {
    private List<User> friends = new ArrayList<>();

    @Override
    public List<User> getFriends(User user) {
        return friends;
    }

    @Override
    public void addFriend(User user, User friend) {
        friends.add(user);
    }
}
