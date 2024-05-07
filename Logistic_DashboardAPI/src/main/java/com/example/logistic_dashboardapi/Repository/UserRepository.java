package com.example.logistic_dashboardapi.Repository;

import com.example.logistic_dashboardapi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
