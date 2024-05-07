package com.example.logistic_dashboardapi.Service;


import com.example.logistic_dashboardapi.DTO.AssistantDto;
import com.example.logistic_dashboardapi.Model.Assistant;
import com.example.logistic_dashboardapi.Repository.AssistantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

import java.util.List;

@Service
public class AssistantService {

    @Autowired
    private AssistantRepository assistantRepository;


    public boolean isUsernameExists(String username) {
        return assistantRepository.existsByUsername(username);
    }
    public Assistant AddAssistant(AssistantDto assistantDto) {
        Assistant assistant = new Assistant(); //new
        assistant.setName(assistantDto.getName());
        assistant.setUsername(assistantDto.getUsername());
        assistant.setEmail(assistantDto.getEmail());
        assistant.setPrivilege(assistantDto.getPrivilege());
        assistant.setPassword(assistantDto.getPassword());
        assistant.setRole(assistantDto.getRole());

        return assistantRepository.save(assistant);
    }

    public List<Assistant> getAllAssistants() {
        return assistantRepository.findAll();
    }

    public boolean deleteAssistant(Long id) {
        Optional<Assistant> optionalAssistant = assistantRepository.findById(id);
        if (optionalAssistant.isPresent()) {
            assistantRepository.delete(optionalAssistant.get());
            return true;
        }
        return false;
    }
    public Assistant updateAssistant(Long id, AssistantDto assistantDto) {
        Optional<Assistant> optionalAssistant = assistantRepository.findById(id);
        if (optionalAssistant.isPresent()) {
            Assistant assistant = optionalAssistant.get();
            assistant.setName(assistantDto.getName());
            assistant.setUsername(assistantDto.getUsername());
            assistant.setEmail(assistantDto.getEmail());
            assistant.setPrivilege(assistantDto.getPrivilege());

            if (assistantDto.getPassword() != null && !assistantDto.getPassword().isEmpty()) {
                assistant.setPassword(assistantDto.getPassword());
            }
            return assistantRepository.save(assistant);
        } else {
            throw new NoSuchElementException("Assistant with ID " + id + " not found");

        }
    }
}
