package com.meli.interview.back.subscription_api.application.service;

import com.meli.interview.back.subscription_api.domain.User;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    private final FriendshipService friendshipService;

    public SubscriptionService(FriendshipService friendshipService) {
        this.friendshipService = friendshipService;
    }

    public float calculateUserSubscriptionsCost(User user) {
        // Lógica para calcular el costo total de las suscripciones del usuario
        // Puedes usar el FriendshipService y otras clases del dominio según sea necesario
        // ...
        return 0.0f;  // Reemplaza con la lógica real
    }
}