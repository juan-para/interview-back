package com.meli.interview.back.subscription_api.domain;

public enum Partner {
    DISNEY(100),
    NETFLIX(200),
    SPOTIFY(50),
    DEFAULT(0);

    private final float price;

    Partner(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
}