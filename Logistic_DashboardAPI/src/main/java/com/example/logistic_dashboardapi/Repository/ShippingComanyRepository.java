package com.example.logistic_dashboardapi.Repository;

import com.example.logistic_dashboardapi.Model.Assistant;
import com.example.logistic_dashboardapi.Model.ShippingCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingComanyRepository extends JpaRepository<ShippingCompany, Long> {
    boolean existsByUsername(String username);
}