package com.example.logistic_dashboardapi.Controller;

import com.example.logistic_dashboardapi.DTO.AssistantDto;
import com.example.logistic_dashboardapi.Model.Assistant;
import com.example.logistic_dashboardapi.Service.AssistantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/assistants")
public class AssistantController {
    @Autowired
    AssistantService assistantService;
    @PostMapping("/Create")
    public ResponseEntity<Map<String, Object>> addAssistant(@RequestBody AssistantDto assistantDto) {
        assistantDto.setRole("Assistant");

        // Check if the username already exists
        boolean usernameExists = assistantService.isUsernameExists(assistantDto.getUsername());
        if (usernameExists) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Username already exists. Please choose a different username.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        // Check if any required fields are missing or empty
        if (assistantDto.getName().isEmpty() ||
                assistantDto.getPassword().isEmpty() ||
                assistantDto.getUsername().isEmpty() ||
                assistantDto.getEmail().isEmpty() ||
                assistantDto.getPrivilege().isEmpty() ||
                assistantDto.getRole().isEmpty()) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Required fields are missing or empty. Please provide all the necessary information.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
            assistantService.AddAssistant(assistantDto);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Assistant added successfully");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/Get")
    public ResponseEntity<List<Assistant>> getAllAssistants() {
        List<Assistant> assistants = assistantService.getAllAssistants();
        if (!assistants.isEmpty()) {
            return ResponseEntity.ok(assistants);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAssistant(@PathVariable Long id) {
        boolean deleted = assistantService.deleteAssistant(id);
        if (deleted) {
            return ResponseEntity.ok("Assistant deleted successfully");
        } else {
//            return ResponseEntity.notFound().build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assistant with ID " + id + "  not found");


        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAssistant(@PathVariable Long id, @RequestBody AssistantDto assistantDto) {
        Assistant updatedAssistant = assistantService.updateAssistant(id, assistantDto);
        if (updatedAssistant != null) {
            return ResponseEntity.ok(updatedAssistant);
        } else {
//            return ResponseEntity.notFound().build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assistant with ID " + id + "  not found");
        }
    }

}
