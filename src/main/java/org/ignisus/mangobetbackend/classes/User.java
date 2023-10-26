package org.ignisus.mangobetbackend.classes;

import org.ignisus.mangobetbackend.enums.UserRole;



public class User {
    private String id;
    private String username;
    private String password;
    private String email;
    private UserRole role;


    // CONSTRUCTORS

    public User(String id, String username, String password, String email,UserRole  role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    public User(String username, String password, String email) { // No ID, Role
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public User() {} // Empty constructor for Spring


    // METHODS
    public void printUser() {
        System.out.println("User: " + this.username + " (" + this.email + ")");
    }




    // GETTERS AND SETTERS

    public String getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public UserRole getRole() {
        return role;
    }
    public String getUsername() {
        return username;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }

}
