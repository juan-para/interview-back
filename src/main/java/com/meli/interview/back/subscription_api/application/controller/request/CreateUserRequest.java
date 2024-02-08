package com.meli.interview.back.subscription_api.application.controller.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
public class CreateUserRequest {
    @NotBlank(message = "El nombre de usuario no puede estar en blanco")
    @Size(min = 3, max = 15, message = "El nombre de usuario debe tener entre 3 y 15 caracteres")
    private String userName;
}