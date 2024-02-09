package com.meli.interview.back.subscription_api.infrastructure;

import com.meli.interview.back.subscription_api.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FriendshipRepositoryTest {

    private FriendshipRepository friendshipRepository;

    @BeforeEach
    void setUp() {
        friendshipRepository = new FriendshipRepository();
    }

    @Test
    void testGetFriends() {
        String userId = "123";
        User friend1 = new User("1", "Friend1", null);
        User friend2 = new User("2", "Friend2", null);

        friendshipRepository.addFriend(userId, friend1);
        friendshipRepository.addFriend(userId, friend2);

        List<User> friends = friendshipRepository.getFriends(userId);

        assertEquals(2, friends.size());
        assertEquals(friend1, friends.get(0));
        assertEquals(friend2, friends.get(1));
    }

    @Test
    void testAddFriend() {
        String userId = "123";
        User friend = new User("1", "Friend", null);

        friendshipRepository.addFriend(userId, friend);

        List<User> friends = friendshipRepository.getFriends(userId);

        assertEquals(1, friends.size());
        assertEquals(friend, friends.get(0));
    }
}
