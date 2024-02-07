package com.meli.interview.back.subscription_api.session;

import com.meli.interview.back.subscription_api.domain.User;
import com.meli.interview.back.subscription_api.exception.CollaboratorCallException;
import com.meli.interview.back.subscription_api.exception.UserNotLoggedInException;

public class UserSession {

    private static final UserSession userSession = new UserSession();
    private static User loggedUser;

    private UserSession() {
    }

    public static UserSession getInstance() {
        return userSession;
    }

    public User getLoggedUser() {
        if (loggedUser == null) {
            throw new UserNotLoggedInException();
        }
        return loggedUser;
    }

    public void setLoggedUser(User user) {
        this.loggedUser = user;
    }

    public void clearLoggedUser() {
        this.loggedUser = null;
    }
}
