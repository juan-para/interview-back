package com.meli.interview.back.subscription_api.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.interview.back.subscription_api.application.controller.request.CreateUserRequest;
import com.meli.interview.back.subscription_api.application.service.UserService;
import com.meli.interview.back.subscription_api.domain.User;
import com.meli.interview.back.subscription_api.infrastructure.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @Test
    public void testCreateUser() throws Exception {
        User mockedUser = User.builder()
                .id("1")
                .name("Juan")
                .subscribedList(new ArrayList<>())
                .build();

        CreateUserRequest request = CreateUserRequest.builder()
                .userName("Juan")
                .build();

        when(userService.createUser("Juan")).thenReturn(mockedUser);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/createUser")
                        .content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Usuario creado exitosamente: " + mockedUser));

        verify(userService, times(1)).createUser("Juan");
        verify(userRepository, times(1)).saveUser(mockedUser);
    }
}