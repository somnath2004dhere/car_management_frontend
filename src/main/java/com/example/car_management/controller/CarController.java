package com.example.car_management.controller;

import com.example.car_management.model.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
public class CarController {

    @GetMapping("/car-register")
    public String showCarRegisterPage(Model model) {
        model.addAttribute("car", new Car()); // Add a new Car object to the model
        return "car-register";
    }

    @PostMapping("/register")
    public String submitCarForm(@ModelAttribute Car car, BindingResult result, Model model) {
        String BASE_URL = "http://localhost:8000"; // Define backend base URL
        RestTemplate restTemplate = new RestTemplate(); // Create RestTemplate instance


        try {
            // Call backend API to add the car
            ResponseEntity<String> response = restTemplate.postForEntity(
                BASE_URL + "/addCar", // Backend endpoint
                car,                 // Data to send
                String.class         // Response type
            );

            // Handle successful response
            model.addAttribute("successMessage", response.getBody());
            return "redirect:/"; // Redirect to home or success page
        } catch (HttpClientErrorException e) {
            // Parse backend validation errors
            Map<String, String> errors = null;
            try {
                errors = new ObjectMapper().readValue(
                    e.getResponseBodyAsString(),
                    new TypeReference<Map<String, String>>() {}
                );
            } catch (JsonProcessingException ex) {
                model.addAttribute("errorMessage", "An error occurred while parsing backend errors.");
                return "car-register";
            }


            // Map backend errors to BindingResult
            for (Map.Entry<String, String> entry : errors.entrySet()) {
                String field = entry.getKey();
                String errorMessage = entry.getValue();
                result.rejectValue(field, "", errorMessage);
            }
        } catch (Exception e) {
            // Handle generic exceptions
            model.addAttribute("errorMessage", "An unexpected error occurred: " + e.getMessage());
            return "car-register";
        }

        // Stay on the registration page and display validation errors
        return "car-register";

    }

}
