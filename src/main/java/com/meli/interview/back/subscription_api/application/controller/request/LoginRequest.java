package com.meli.interview.back.subscription_api.application.controller.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class LoginRequest {

    @NotBlank(message = "El nombre de usuario no puede estar en blanco")
    private String userId;
    private String pass;
}