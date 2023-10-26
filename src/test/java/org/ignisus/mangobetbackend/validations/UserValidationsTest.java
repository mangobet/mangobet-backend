package org.ignisus.mangobetbackend.validations;

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
public class UserValidationsTest {

    
    String[] miArray = {
        "{\"username\":\"t\",\"email\":\"test@example.com\",\"password\":\"1234\"}",
        "{\"username\":\"hola\",\"email\":\"test@example.com\",\"password\":\"1234\"}",
        "{\"username\":\"123ho\",\"email\":\"test@example.com\",\"password\":\"1234\"}",
        "{\"username\":\"*efeef\",\"email\":\"test@example.com\",\"password\":\"1234\"}",
        "{\"username\":\"wh!()\",\"email\":\"test@example.com\",\"password\":\"1234\"}",
        "{\"username\":\"!\",\"email\":\"test@example.com\",\"password\":\"1234\"}",
        "{\"username\":\"1938834949819\",\"email\":\"test@example.com\",\"password\":\"1234\"}",
        "{\"username\":\"qhfwqhqou21u2821qfqw\",\"email\":\"test@example.com\",\"password\":\"1234\"}",
        "{\"username\":\"218u21hbhhbhh\",\"email\":\"test@example.com\",\"password\":\"1234\"}",
        "{\"username\":\"2823ehwo\",\"email\":\"test@example.com\",\"password\":\"1234\"}",
    };
    @Autowired
    private TestRestTemplate restTemplate;
    

    @Test
    
    public void UserNamelenfhtJSON() {
        // Preparar los datos a enviar en la solicitud
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        for (int i = 0; i < miArray.length; i++) {
            // Realizar la solicitud POST
            ResponseEntity<String> response = restTemplate.exchange("/user", HttpMethod.POST, new HttpEntity<>(miArray[i], headers), String.class);

            // Verificar que la respuesta sea 200 OK
            assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        }

    }

}
