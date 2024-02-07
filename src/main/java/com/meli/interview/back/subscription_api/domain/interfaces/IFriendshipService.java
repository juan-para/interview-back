package com.meli.interview.back.subscription_api.domain.interfaces;

import com.meli.interview.back.subscription_api.domain.User;

import java.util.List;

public interface IFriendshipService {
    List<User> getFriends(String userId);
    void addFriend(String userId, String friendId);
}