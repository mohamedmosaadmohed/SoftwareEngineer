package com.example.logistic_dashboardapi.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Login")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String username;
    private String password;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}