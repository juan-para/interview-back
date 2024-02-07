package com.meli.interview.back.subscription_api.application.controller.response;

import com.meli.interview.back.subscription_api.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class UserFriendsResponse {
    private String userId;
    private List<User> friends;

}