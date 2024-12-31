package com.example.car_management.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.example.car_management.model.Car;

@Configuration
@Controller
public class CarController {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/car-register")
    public String showCarRegisterPage(Model model) {
        model.addAttribute("car", new Car());
        return "car-register"; // Thymeleaf template without ".html"
    }

    @PostMapping("/register")
    public String submitCarForm(@ModelAttribute Car car, Model model) {
        String backendUrl = "http://localhost:8000/addCar";
        try {
            // Prepare HTTP headers and request body
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");

            HttpEntity<Car> request = new HttpEntity<>(car, headers);

            // Make POST request to backend service
            ResponseEntity<String> response = restTemplate().exchange(
                backendUrl,
                HttpMethod.POST,
                request,
                String.class
            );

            // Process response
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                model.addAttribute("successMessage", "Car registered successfully!");
                return "redirect:/";
            } else {
                model.addAttribute("errorMessage", response.getBody() != null
                    ? "Backend error: " + response.getBody()
                    : "Failed to register the car. Please try again.");
            }
        } catch (Exception e) {
            // Log the exception (logging can be added here for production)
            model.addAttribute("errorMessage", "An error occurred while processing your request: " + e.getMessage());
        }

        // Stay on the registration page with status messages
        return "redirect:/car-register";
    }
}
