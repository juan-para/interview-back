package com.meli.interview.back.subscription_api.application.controller;

import com.meli.interview.back.subscription_api.application.controller.request.LoginRequest;
import com.meli.interview.back.subscription_api.application.service.UserService;
import com.meli.interview.back.subscription_api.domain.User;
import com.meli.interview.back.subscription_api.exception.UserNotLoggedInException;
import com.meli.interview.back.subscription_api.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {

    // Solo para autenticar pero deberia ser un servicio authenticator
    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        // Suponemos que hay un servicio autenticador... y devuelve un usuario valido autenticado
        UserSession.getInstance().setLoggedUser(
                userService.getUserById(loginRequest.getUserId()).get()
        );
        return ResponseEntity.ok("Login successful");
    }

    @PostMapping("/logout")
    @ResponseBody
    public ResponseEntity<String> logout() {
        try {
            UserSession.getInstance().clearLoggedUser();
            return ResponseEntity.ok("Logout successful");
        } catch (UserNotLoggedInException e) {
            return ResponseEntity.status(401).body("User Not Logged In");
        }
    }
}