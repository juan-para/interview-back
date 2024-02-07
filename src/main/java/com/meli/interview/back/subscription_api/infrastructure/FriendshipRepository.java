package com.meli.interview.back.subscription_api.infrastructure;

import com.meli.interview.back.subscription_api.domain.User;
import com.meli.interview.back.subscription_api.domain.interfaces.IFriendshipRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FriendshipRepository implements IFriendshipRepository {

    private final Map<String, List<User>> friendsList = new HashMap<>();

    @Override
    public List<User> getFriends(String userId) {
        return friendsList.get(userId);
    }

    @Override
    public void addFriend(String userId, User friend) {
        //Lo agrego a un nuevo array si la key no tiene valores asociados
        friendsList.computeIfAbsent(userId, k -> new ArrayList<>()).add(friend);
    }
}