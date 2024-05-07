package com.example.logistic_dashboardapi.Repository;

import com.example.logistic_dashboardapi.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
