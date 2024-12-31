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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.car_management.model.Car;

@Configuration
@Controller
public class CarUpdateController {

	@Bean
	public RestTemplate carUpdateControllerRestTemplate() {
	    return new RestTemplate();
	}

    // Display the car update page
    @GetMapping("/update-car")
    public String showCarUpdatePage(Model model) {
        model.addAttribute("car", new Car()); // Empty Car object for form binding
        return "update"; // Thymeleaf template without ".html"
    }

    @GetMapping("/update")
    public String fetchCarDetails(@RequestParam String registrationNumber, Model model) {
        String backendUrl = "http://localhost:8000/getCar/registrationnumber/" + registrationNumber;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");

            ResponseEntity<Car> response = carUpdateControllerRestTemplate().exchange(
                backendUrl,
                HttpMethod.GET,
                null,
                Car.class
            );

            Car car = response.getBody();

            if (car != null) {
                model.addAttribute("car", car);
                return "car-update"; // Display update form with car details
            } else {
                model.addAttribute("errorMessage", "Car not found for the given registration number.");
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", "An error occurred while retrieving the car: " + e.getMessage());
        }

        return "redirect:/search-car"; // Redirect to status page for error display
    }

    @PostMapping("/update-car")
    public String updateCarDetails(@ModelAttribute Car car, Model model) {
        String backendUrl = "http://localhost:8000/updateCar";

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");

            HttpEntity<Car> request = new HttpEntity<>(car, headers);

            ResponseEntity<Car> response = carUpdateControllerRestTemplate().exchange(
                backendUrl,
                HttpMethod.PUT,
                request,
                Car.class
            );

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                model.addAttribute("action", "Updation");
                model.addAttribute("successMessage", "Car updated successfully!");
            } else {
                model.addAttribute("errorMessage", "Failed to update the car. Please try again.");
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", "An error occurred while updating the car: " + e.getMessage());
        }

        return "redirect:/"; // Redirect to status page
    }
}
