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

    
    String[] BAD_USERNAMES = {
        "a",
        "ab",
        "abc",
        "abcd",
        "1kjefe",
        "1kjefe1",
        "1kjefe12",
        "88213948",
        "hojhf**",
        "hi123^",
        "efhuefeuhufhuueuhfuhhf",
        "ueuhefuhfuehfe",
        "a123456789"
    };
    String[] GOOD_USERNAMES = {
        "Juan12",
        "Juan123",
        "pepeAE",
        "p12345678",
        "jJjJjJ",
        "JjJjJj",
        "J1234"
    };
    @Autowired
    private TestRestTemplate restTemplate;
    

    @Test
    public void usernameLenfhtJSON() {
        // Preparar los datos a enviar en la solicitud
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        String requestBody;
 
        for (int i = 0; i < BAD_USERNAMES.length; i++) {
            // Realizar la solicitud POST
            requestBody="{\"username\":\""+ BAD_USERNAMES[i] + "\",\"email\":\"test@example.com\",\"password\":\"1234\"}";

            ResponseEntity<String> response = restTemplate.exchange("/user", HttpMethod.POST, new HttpEntity<>(requestBody, headers), String.class);

            // Verificar que la respuesta sea 200 OK
            assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        }

    }

    @Test
    public void usernameLenfhtXML() {
        HttpHeaders headers = new HttpHeaders();                                // create headers
        headers.add("Content-Type", "application/xml"); // add xml content type

        String requestBody;
        for (int i = 0; i < BAD_USERNAMES.length; i++) {              // Test for each element in the array
            requestBody="<user>\n" +                                        // create the body xml
             "    <username>"+ BAD_USERNAMES[i]+"</username>\n" +
             "    <email>juan@email.com</email>\n" +
             "    <password>1234</password>\n" +
             "</user>";
            
            // Realizar la solicitud POST
            ResponseEntity<String> response = restTemplate.exchange("/user", HttpMethod.POST, new HttpEntity<>(requestBody, headers), String.class);

            // Verificar que la respuesta sea 200 OK
            assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        }

    }

    @Test 
    public void usernameNotNullTest() {
        HttpHeaders headers = new HttpHeaders();                                // create headers
        headers.add("Content-Type", "application/json"); // add xml content type
        // Preparar los datos a enviar en la solicitud
        String requestBody="{\",\"email\":\"test@example.com\",\"password\":\"1234\"}";
        // Realizar la solicitud POST
        ResponseEntity<String> response = restTemplate.exchange("/user", HttpMethod.POST, new HttpEntity<>(requestBody, headers), String.class);

        // Verificar que la respuesta sea 200 OK
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void emailNotNullTest() {
        HttpHeaders headers = new HttpHeaders();                                // create headers
        headers.add("Content-Type", "application/json"); // add xml content type
        // Preparar los datos a enviar en la solicitud
        String requestBody="{\"username\":\"testUser\",\"password\":\"1234\"}";
        // Realizar la solicitud POST
        ResponseEntity<String> response = restTemplate.exchange("/user", HttpMethod.POST, new HttpEntity<>(requestBody, headers), String.class);

        // Verificar que la respuesta sea 200 OK
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }


    @Test
    public void passwordNotNullTest() {
        HttpHeaders headers = new HttpHeaders();                                // create headers
        headers.add("Content-Type", "application/json"); // add xml content type
        // Preparar los datos a enviar en la solicitud
        String requestBody="{\"username\":\"testUser\",\"email\":\"}";
        // Realizar la solicitud POST
        ResponseEntity<String> response = restTemplate.exchange("/user", HttpMethod.POST, new HttpEntity<>(requestBody, headers), String.class);

        // Verificar que la respuesta sea 200 OK
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void emailFormatTest() {
        HttpHeaders headers = new HttpHeaders();                                // create headers
        headers.add("Content-Type", "application/json"); // add xml content type
        // Preparar los datos a enviar en la solicitud
        String requestBody="{\"username\":\"testUser\",\"email\":\"testexample\",\"password\":\"1234\"}";
        // Realizar la solicitud POST
        ResponseEntity<String> response = restTemplate.exchange("/user", HttpMethod.POST, new HttpEntity<>(requestBody, headers), String.class);

        // Verificar que la respuesta sea 200 OK
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        requestBody="{\"username\":\"testUser\",\"email\":\"test.example\",\"password\":\"1234\"}";
        // Realizar la solicitud POST
        ResponseEntity<String> response2 = restTemplate.exchange("/user", HttpMethod.POST, new HttpEntity<>(requestBody, headers), String.class);

        // Verificar que la respuesta sea 200 OK
        assertEquals(HttpStatus.BAD_REQUEST, response2.getStatusCode());
        requestBody="{\"username\":\"testUser\",\"email\":\"test@example.com\",\"password\":\"1234\"}";
        // Realizar la solicitud POST
        ResponseEntity<String> response3 = restTemplate.exchange("/user", HttpMethod.POST, new HttpEntity<>(requestBody, headers), String.class);

        // Verificar que la respuesta sea 200 OK
        assertEquals(HttpStatus.OK, response3.getStatusCode());
    }


}
