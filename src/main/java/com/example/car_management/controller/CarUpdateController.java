package com.example.car_management.controller;

import com.example.car_management.model.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class CarUpdateController {

    private final RestTemplate restTemplate;

    @Autowired
    public CarUpdateController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    

    @GetMapping("/update-car")
    public String showCarUpdatePage(Model model) {
        model.addAttribute("car", new Car()); // Add Car object to model for form binding
        return "verify-reg";
    }

    @GetMapping("/update")
    public String fetchCarDetails(@ModelAttribute Car car, Model model) {
        String backendUrl = "http://localhost:8000/getCar/registrationnumber/" + car.getRegistrationNumber();

        try {
            ResponseEntity<Car> response = restTemplate.exchange(
                backendUrl,
                HttpMethod.GET,
                null,
                Car.class
            );

            Car fetchedCar = response.getBody();
            if (fetchedCar != null) {
                model.addAttribute("car", fetchedCar);
                return "car-update"; // Display update form with car details
            }
        } catch (HttpClientErrorException.NotFound e) {
            // Handle 404 error and pass the backend error message to the template
            String errorMessage = e.getResponseBodyAsString();
            model.addAttribute("errorMessage", errorMessage);
        } catch (Exception e) {
            // Handle unexpected errors
            model.addAttribute("errorMessage", "An error occurred while retrieving the car: " + e.getMessage());
        }

        return "verify-reg"; // Stay on the verification page and display the error message
    }


    @PostMapping("/update-car")
    public String updateCarDetails(@ModelAttribute Car car, BindingResult result, Model model) {
        String backendUrl = "http://localhost:8000/updateCar";

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");

            HttpEntity<Car> request = new HttpEntity<>(car, headers);

            ResponseEntity<Car> response = restTemplate.exchange(
                backendUrl,
                HttpMethod.PUT,
                request,
                Car.class
            );

            if (response.getStatusCode().is2xxSuccessful()) {
                model.addAttribute("successMessage", "Car updated successfully!");
                return "redirect:/";
            }
        } catch (HttpClientErrorException.BadRequest e) {
            // Parse backend validation errors
            Map<String, String> errors = parseErrors(e);
            if (errors != null) {
                for (Map.Entry<String, String> entry : errors.entrySet()) {
                    result.addError(new FieldError("car", entry.getKey(), entry.getValue()));
                }
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", "An unexpected error occurred while updating the car: " + e.getMessage());
        }

        return "car-update";
    }

    private Map<String, String> parseErrors(HttpClientErrorException e) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(e.getResponseBodyAsString(), new TypeReference<Map<String, String>>() {});
        } catch (Exception ex) {
            return null;
        }
    }
}
