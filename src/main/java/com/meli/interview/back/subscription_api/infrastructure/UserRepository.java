package com.meli.interview.back.subscription_api.infrastructure;

import com.meli.interview.back.subscription_api.domain.Subscription;
import com.meli.interview.back.subscription_api.domain.User;
import com.meli.interview.back.subscription_api.domain.interfaces.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {

    private List<User> userList = new ArrayList<>();

    @Override
    public Optional<User> findUserById(String id) {
        return userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public void saveUser(User user) {
        userList.add(user);
    }

    @Override
    public void addSubscriptionToUser(String userId, Subscription subscription) {
        User updatedUser = findUserById(userId).get();
        updatedUser.getSubscribedList().add(subscription);
    }

}