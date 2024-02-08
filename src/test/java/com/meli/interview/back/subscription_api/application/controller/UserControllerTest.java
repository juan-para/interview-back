package com.meli.interview.back.subscription_api.application.controller;

import com.meli.interview.back.subscription_api.application.controller.request.CreateUserRequest;
import com.meli.interview.back.subscription_api.application.service.UserService;
import com.meli.interview.back.subscription_api.domain.User;
import com.meli.interview.back.subscription_api.infrastructure.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        User mockedUser = User.builder()
                .id("123123")
                .name("Juan")
                .subscribedList(new ArrayList<>())
                .build();

        when(userService.createUser(anyString())).thenReturn(mockedUser);

        CreateUserRequest request = CreateUserRequest.builder()
                .userName("Juan")
                .build();

        ResponseEntity<String> responseEntity = restTemplate.postForEntity("/createUser", request, String.class);

        // Verifica el estado y el cuerpo de la respuesta
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).contains("Usuario creado exitosamente:");

        // Verifica las interacciones con los mocks
        verify(userService, times(1)).createUser(anyString());
        verify(userRepository, times(1)).saveUser(mockedUser);
    }
}
