package com.meli.interview.back.subscription_api.domain;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

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
