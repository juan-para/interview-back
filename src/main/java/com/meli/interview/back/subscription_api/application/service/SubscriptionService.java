package com.meli.interview.back.subscription_api.application.service;

import com.meli.interview.back.subscription_api.domain.Subscription;
import com.meli.interview.back.subscription_api.domain.User;
import com.meli.interview.back.subscription_api.domain.interfaces.ISubscriptionService;
import com.meli.interview.back.subscription_api.exception.UserNotLoggedInException;
import com.meli.interview.back.subscription_api.infrastructure.SubscriptionRepository;
import com.meli.interview.back.subscription_api.session.UserSession;
import com.meli.interview.back.subscription_api.subscription.SubscriptionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriptionService implements ISubscriptionService {


    @Autowired
    private FriendshipService friendshipService;
    @Autowired
    private UserService userService;
    @Autowired
    private SubscriptionService subscriptionService;

    public SubscriptionService(FriendshipService friendshipService) {
        this.friendshipService = friendshipService;
    }

    /**
     * Devuelve el costo total de las suscripciones de un usuario siempre que el usuario que esté logueado
     * se encuentre en su lista de amigos
     * @param user
     * @return costo total de la suscripciones del user
     * @throws UserNotLoggedInException si no hay un usuario logueado
     */
    @Override
    public float getUserSubscriptionsCost(User user) throws UserNotLoggedInException {
        User loggedUser = UserSession.getInstance().getLoggedUser();
        checkUserLoggedIn(loggedUser);

        if (isFriend(user, loggedUser)) {
            ArrayList<Subscription> subscriptionList = subscriptionService.findSubscriptionByUserId(user.getId());
            return calculateTotalPrice(subscriptionList);
        } else {
            return 0f;
        }
    }

    @Override
    public ArrayList<Subscription> findSubscriptionByUserId(String id) {
        User user = userService.getUserById(id).get();
        return user.getSubscribedList();
    }

    private boolean isFriend(User user, User loggedUser){
        // No puede no devolver nulo por como lo implemente
        // Me hace ruido este metodo, porque deberia tenerlo como amigo para loguearme?
        // El usuario se tiene que agregar como amigo mismo...
        return friendshipService.getFriends(user.getId()).contains(loggedUser);
    }

    private float calculateTotalPrice(ArrayList<Subscription> subscriptionList){
        float totalPrice = 0f;
        for (Subscription subscription : subscriptionList) {
            // No puede devolver nulo por como esta en el enum
            totalPrice += subscription.getPrice();
        }
        return totalPrice;
    }

    private void checkUserLoggedIn(User user) throws UserNotLoggedInException {
        if (user == null) {
            throw new UserNotLoggedInException();
        }
    }
}