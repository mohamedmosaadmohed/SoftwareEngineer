package com.example.logistic_dashboardapi.Service;
import com.example.logistic_dashboardapi.DTO.AssistantDto;
import com.example.logistic_dashboardapi.DTO.ShippingCompanyDto;
import com.example.logistic_dashboardapi.Model.ShippingCompany;
import com.example.logistic_dashboardapi.Repository.ShippingComanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ShippingCompanyService {

    @Autowired
    private ShippingComanyRepository shippingComanyRepository;

    public boolean isUsernameExists(String username) {
        return shippingComanyRepository.existsByUsername(username);
    }
    public ShippingCompany AddShippingCompany(ShippingCompanyDto shippingCompanyDto) {
        ShippingCompany shippingCompany = new ShippingCompany(); //new
        shippingCompany.setName(shippingCompanyDto.getName());
        shippingCompany.setUsername(shippingCompanyDto.getUsername());
        shippingCompany.setEmail(shippingCompanyDto.getEmail());
        shippingCompany.setPassword(shippingCompanyDto.getPassword());
        shippingCompany.setRole(shippingCompanyDto.getRole());

        return shippingComanyRepository.save(shippingCompany);
    }

    public List<ShippingCompany> getShippingCompany() {
        return shippingComanyRepository.findAll();
    }

    public boolean deleteShippingCompany(Long id) {
        Optional<ShippingCompany> optionalShippingCompany = shippingComanyRepository.findById(id);
        if (optionalShippingCompany.isPresent()) {
            shippingComanyRepository.delete(optionalShippingCompany.get());
            return true;
        }
        return false;
    }
    public ShippingCompany updateShippingCompany(Long id, ShippingCompanyDto shippingCompanyDto) {
        Optional<ShippingCompany> optionalAssistant = shippingComanyRepository.findById(id);
        if (optionalAssistant.isPresent()) {
            ShippingCompany assistant = optionalAssistant.get();
            assistant.setName(shippingCompanyDto.getName());
            assistant.setUsername(shippingCompanyDto.getUsername());
            assistant.setEmail(shippingCompanyDto.getEmail());

            if (shippingCompanyDto.getPassword() != null && !shippingCompanyDto.getPassword().isEmpty()) {
                assistant.setPassword(shippingCompanyDto.getPassword());
            }
            return shippingComanyRepository.save(assistant);
        } else {
            throw new NoSuchElementException("Assistant with ID " + id + " not found");

        }
    }
}
