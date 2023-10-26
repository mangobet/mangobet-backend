package org.ignisus.mangobetbackend.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateUser() {
        // Preparar los datos a enviar en la solicitud
        String requestBody = "{\"username\":\"testUser\",\"email\":\"test@example.com\",\"password\":\"1234\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        // Realizar la solicitud POST
        ResponseEntity<String> response = restTemplate.exchange("/user", HttpMethod.POST, new HttpEntity<>(requestBody, headers), String.class);

        // Verificar que la respuesta sea 200 OK
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("user created testUser", response.getBody());
    }
}
