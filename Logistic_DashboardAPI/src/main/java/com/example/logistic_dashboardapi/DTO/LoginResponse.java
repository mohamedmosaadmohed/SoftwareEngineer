package com.example.logistic_dashboardapi.DTO;

public class LoginResponse {
    private String message;
    private String username;
    private Long id;
    private String password;

    // Constructor
    public LoginResponse(String message, String username, Long id,String password) {
        this.message = message;
        this.username = username;
        this.id = id;
        this.password = password;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

