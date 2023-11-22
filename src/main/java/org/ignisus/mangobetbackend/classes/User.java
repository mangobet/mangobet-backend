package org.ignisus.mangobetbackend.classes;

import org.ignisus.mangobetbackend.classes.enums.UserRole;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;





@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;

    @Size(min = 5, max = 9, message = "El username debe tener entre 5 y 9 caracteres.")
    @Pattern(regexp = "^[A-Za-z][A-Za-z0-9]*$", message = "El username debe comenzar con una letra y contener solo letras y números.")
    private String username;

    @NotNull
    private String password;

    @NotNull
    @Email(message = "El email debe ser válido.")
    private String email;
    private UserRole role;

    private int mangoCoints;


    // CONSTRUCTORS
    public User(String username, String password, String email) { // No ID, Role
        this.username = username;
        this.password = password;
        this.email = email;
    }

}
