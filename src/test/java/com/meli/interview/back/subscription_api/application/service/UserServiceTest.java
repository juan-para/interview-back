package com.meli.interview.back.subscription_api.application.service;

import com.meli.interview.back.subscription_api.domain.Subscription;
import com.meli.interview.back.subscription_api.domain.User;
import com.meli.interview.back.subscription_api.infrastructure.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateUser() {
        // Arrange
        String userName = "Juan";

        // Act
        User createdUser = userService.createUser(userName);

        // Assert
        assertEquals(userName, createdUser.getName());
        //verify(userRepository, times(1)).saveUser(createdUser);
    }

    @Test
    void testGetUserById() {
        // Arrange
        String userId = "1111";
        User expectedUser = new User(userId, "Juan", new ArrayList<>());
        when(userRepository.findUserById(userId)).thenReturn(expectedUser);

        // Act
        User retrievedUser = userService.getUserById(userId);

        // Assert
        assertEquals(expectedUser, retrievedUser);
    }

    @Test
    void testAddSubscriptionByUser() {
        // Arrange
        String userId = "1111";
        Subscription subscription = new Subscription();
        User user = new User(userId, "Juan", new ArrayList<>());

        // Act
        userService.addSubscriptionByUser(userId, subscription);

        // Assert
        verify(userRepository, times(1)).addSubscriptionToUser(userId, subscription);
    }
}
