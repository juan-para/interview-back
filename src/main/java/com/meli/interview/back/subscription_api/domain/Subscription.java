package com.meli.interview.back.subscription_api.domain;

import org.springframework.stereotype.Component;

@Component
public class Subscription {
    private Partner partner;

    public Subscription(Partner partner) {
        this.partner = partner;
    }

    public float getPrice() {
        return partner.getPrice();
    }
}
