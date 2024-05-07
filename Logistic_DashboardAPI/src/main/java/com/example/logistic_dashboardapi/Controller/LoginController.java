package com.example.logistic_dashboardapi.Controller;

import com.example.logistic_dashboardapi.Model.User;
import com.example.logistic_dashboardapi.DTO.LoginResponse;
import com.example.logistic_dashboardapi.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class LoginController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginResponse login) {
        User authenticatedUser = authService.authenticate(login.getUsername(), login.getPassword());
        if (authenticatedUser != null) {
            LoginResponse response = new LoginResponse("Login successful",
                    authenticatedUser.getUsername(), authenticatedUser.getId(),authenticatedUser.getPassword());
            return ResponseEntity.ok().body(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
