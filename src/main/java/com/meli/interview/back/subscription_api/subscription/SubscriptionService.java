package com.meli.interview.back.subscription_api.subscription;

import com.meli.interview.back.subscription_api.application.service.FriendshipService;
import com.meli.interview.back.subscription_api.domain.Subscription;
import com.meli.interview.back.subscription_api.domain.User;
import com.meli.interview.back.subscription_api.exception.UserNotLoggedInException;
import com.meli.interview.back.subscription_api.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

public class SubscriptionService {

    //@Autowired
    //FriendshipService friendshipService;
    /**
     * Devuelve el costo total de las suscripciones de un usuario siempre que el usuario que esté logueado
     * se encuentre en su lista de amigos
     * @param user
     * @return costo total de la suscripciones del user
     * @throws UserNotLoggedInException si no hay un usuario logueado
     */
    /*
    public Float getUserSubscriptionsCost(User user) throws UserNotLoggedInException {
        User loggedUser = UserSession.getInstance().getLoggedUser();

        checkUserLoggedIn(loggedUser);

        if (isFriend(user, loggedUser)) {
            ArrayList<Subscription> subscriptionList = SubscriptionDAO.findSubscriptionByUser(user);
            return calculateTotalPrice(subscriptionList);
        } else {
            return 0f;
        }
    }


    private boolean isFriend(User user, User loggedUser){
        // No puede no devolver nulo por como lo implemente
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
    */

}
