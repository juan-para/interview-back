package com.meli.interview.back.subscription_api.application;

import com.meli.interview.back.subscription_api.application.service.UserService;
import com.meli.interview.back.subscription_api.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    @ResponseBody
    public String createUser(
            @RequestParam String userId,
            @RequestParam String userName) {
        User newUser = userService.createUser(userId, userName);
        // Puedes realizar otras operaciones según tus necesidades...
        return "User created with ID: " + newUser.getId();
    }
}