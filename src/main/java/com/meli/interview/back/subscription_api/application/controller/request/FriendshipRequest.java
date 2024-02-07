package com.meli.interview.back.subscription_api.application.controller.request;

import lombok.Getter;

@Getter
public class FriendshipRequest {
    private String userId;
    private String friendId;
}
