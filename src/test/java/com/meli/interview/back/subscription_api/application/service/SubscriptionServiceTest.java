package com.meli.interview.back.subscription_api.application.service;

import com.meli.interview.back.subscription_api.domain.Partner;
import com.meli.interview.back.subscription_api.domain.Subscription;
import com.meli.interview.back.subscription_api.domain.User;
import com.meli.interview.back.subscription_api.exception.UserNotLoggedInException;
import com.meli.interview.back.subscription_api.session.UserSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class SubscriptionServiceTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private SubscriptionService subscriptionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetUserSubscriptionsCost() throws UserNotLoggedInException {
        ArrayList<Subscription> subscriptions = new ArrayList<>();
        subscriptions.add(new Subscription(Partner.DISNEY));
        subscriptions.add(new Subscription(Partner.SPOTIFY));

        User loggedUser = new User("1111", "Juan", subscriptions);

        // Crear una instancia de UserSession y Configurar la sesión del usuario
        UserSession userSession = UserSession.getInstance();
        userSession.setLoggedUser(loggedUser);

        when(userService.getUserById("1111")).thenReturn(loggedUser);

        // Act
        float cost = subscriptionService.getUserSubscriptionsCost(loggedUser);

        // Assert
        assertEquals(Partner.DISNEY.getPrice() + Partner.SPOTIFY.getPrice(), cost);
    }

    @Test
    void testGetUserSubscriptionsCostUserNotLoggedIn() {
        // Arrange
        User loggedUser = new User("1111", "Juan", new ArrayList<>());
        when(userService.getUserById("2222")).thenReturn(loggedUser);

        // Act and Assert
        assertThrows(UserNotLoggedInException.class, () -> subscriptionService.getUserSubscriptionsCost(loggedUser));
    }

    @Test
    void testFindSubscriptionByUserId() {
        ArrayList<Subscription> subscriptions = new ArrayList<>();
        subscriptions.add( new Subscription(Partner.DISNEY));
        subscriptions.add( new Subscription(Partner.SPOTIFY));

        User loggedUser = new User("2222", "Evangelina", subscriptions);

        // Crear una instancia de UserSession y Configurar la sesión del usuario
        UserSession userSession = UserSession.getInstance();
        userSession.setLoggedUser(loggedUser);

        when(userService.getUserById("2222")).thenReturn(loggedUser);

        // Act
        ArrayList<Subscription> result = subscriptionService.findSubscriptionByUserId("2222");

        // Assert
        assertEquals(subscriptions, result);
    }
}
