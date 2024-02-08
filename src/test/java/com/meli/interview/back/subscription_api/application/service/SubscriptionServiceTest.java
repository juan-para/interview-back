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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

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
        // Logueo el usuario
        User loggedUser = new User("1111", "Juan", new ArrayList<>());
        UserSession.getInstance().setLoggedUser(loggedUser);

        // Creo listado de subscripciones
        ArrayList<Subscription> subscriptions = new ArrayList<>();
        subscriptions.add(new Subscription(Partner.DISNEY));
        subscriptions.add(new Subscription(Partner.SPOTIFY));

        when(subscriptionService.findSubscriptionByUserId("1111")).thenReturn(subscriptions);
        when(userService.getUserById("1111")).thenReturn(Optional.of(loggedUser));


        // Act
        float expectedCost = subscriptionService.getUserSubscriptionsCost(loggedUser);

        // Assert
        assertEquals(expectedCost, Partner.DISNEY.getPrice() + Partner.SPOTIFY.getPrice());
    }

    @Test
    void testGetUserSubscriptionsCostUserNotLoggedIn() {
        // Lo deslogueo al usuario
        UserSession.getInstance().clearLoggedUser();

        User user = new User("2222", "Franco", new ArrayList<>());

        // Devuelvo una excepcion para la ejecucion del metodo
        assertThrows(UserNotLoggedInException.class, () -> subscriptionService.getUserSubscriptionsCost(user));
    }
}