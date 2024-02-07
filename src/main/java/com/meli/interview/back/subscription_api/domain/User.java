package com.meli.interview.back.subscription_api.domain;

import com.meli.interview.back.subscription_api.domain.interfaces.IFriendshipRepository;
import com.meli.interview.back.subscription_api.domain.interfaces.ISubscriptionRepository;
import com.meli.interview.back.subscription_api.infrastructure.FriendshipRepository;
import com.meli.interview.back.subscription_api.infrastructure.SubscriptionRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class User {
    private String id;
    private String name;
    @Builder.Default
    private ArrayList<Subscription> subscribedList = new ArrayList<>();
}
