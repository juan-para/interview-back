package com.meli.interview.back.subscription_api.infrastructure;

import com.meli.interview.back.subscription_api.domain.User;
import com.meli.interview.back.subscription_api.domain.interfaces.IFriendshipRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FriendshipRepository implements IFriendshipRepository {

    private final List<User> friends = new ArrayList<>();

    @Override
    public List<User> getFriends(User user) {
        // Implementación para obtener amigos de un usuario
        // ...
        return new ArrayList<>();  // Reemplaza con la lógica real
    }

    @Override
    public void addFriend(User user, User friend) {
        // Implementación para agregar un amigo a un usuario
        // ...
    }
}