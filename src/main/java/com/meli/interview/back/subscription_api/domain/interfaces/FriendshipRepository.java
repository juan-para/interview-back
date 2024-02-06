package com.meli.interview.back.subscription_api.domain.interfaces;

import com.meli.interview.back.subscription_api.domain.User;

import java.util.List;

public interface FriendshipRepository {
    List<User> getFriends(User user);

    void addFriend(User user, User friend);
}