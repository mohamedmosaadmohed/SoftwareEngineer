package com.example.logistic_dashboardapi.Repository;

import com.example.logistic_dashboardapi.Model.Assistant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistantRepository extends JpaRepository<Assistant, Long> {
    boolean existsByUsername(String username);
}