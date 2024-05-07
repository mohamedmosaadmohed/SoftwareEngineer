package com.example.logistic_dashboardapi.Controller;

import com.example.logistic_dashboardapi.DTO.AssistantDto;
import com.example.logistic_dashboardapi.DTO.ShippingCompanyDto;
import com.example.logistic_dashboardapi.Model.Assistant;
import com.example.logistic_dashboardapi.Model.ShippingCompany;
import com.example.logistic_dashboardapi.Service.AssistantService;
import com.example.logistic_dashboardapi.Service.ShippingCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shippingcompany")
public class ShippingCompanyController {
    @Autowired
    ShippingCompanyService shippingCompanyService;
    @PostMapping("/Create")
    public ResponseEntity<Map<String, Object>> addShippingCompany(@RequestBody ShippingCompanyDto shippingCompanyDto) {
        shippingCompanyDto.setRole("ShippingCompany");
        // Check if the username already exists
        boolean usernameExists = shippingCompanyService.isUsernameExists(shippingCompanyDto.getUsername());
        if (usernameExists) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Username already exists. Please choose a different username.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        // Check if any required fields are missing or empty
        if (shippingCompanyDto.getName().isEmpty() ||
                shippingCompanyDto.getPassword().isEmpty() ||
                shippingCompanyDto.getUsername().isEmpty() ||
                shippingCompanyDto.getEmail().isEmpty() ||
                shippingCompanyDto.getRole().isEmpty()) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Required fields are missing or empty. Please provide all the necessary information.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        ShippingCompany savedShippingCompany = shippingCompanyService.AddShippingCompany(shippingCompanyDto);
        if (savedShippingCompany != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Shipping company added successfully");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Failed to add shipping company");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/Get")
    public ResponseEntity<List<ShippingCompany>> getAllShippingCompany() {
        List<ShippingCompany> shippingCompany = shippingCompanyService.getShippingCompany();
        if (!shippingCompany.isEmpty()) {
            return ResponseEntity.ok(shippingCompany);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteShippingCompany(@PathVariable Long id) {
        boolean deleted = shippingCompanyService.deleteShippingCompany(id);
        if (deleted) {
            return ResponseEntity.ok("Assistant deleted successfully");
        } else {
//            return ResponseEntity.notFound().build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assistant with ID " + id + "  not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateShippingCompany(@PathVariable Long id, @RequestBody ShippingCompanyDto shippingCompanyDto) {
        ShippingCompany updatedShippingCompany = shippingCompanyService.updateShippingCompany(id, shippingCompanyDto);
        if (updatedShippingCompany != null) {
            return ResponseEntity.ok(updatedShippingCompany);
        } else {
//            return ResponseEntity.notFound().build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assistant with ID " + id + "  not found");
        }
    }

}
