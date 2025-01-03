package com.example.car_management.controller;

import com.example.car_management.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Controller
public class CarVerifyController {

    private final RestTemplate restTemplate;

    @Autowired
    public CarVerifyController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/search-car")
    public String showCar(Model model) {
        model.addAttribute("car", new Car()); // Add an empty Car object to the model
        return "search-car";
    }


    @GetMapping("/getCar")
    public String getCar(@ModelAttribute Car car, Model model) {
        String registrationNumber = car.getRegistrationNumber(); // Extract registration number
        String backendUrl = "http://localhost:8000/getCar/registrationnumber/" + registrationNumber;

        try {
            ResponseEntity<Car> response = restTemplate.exchange(
                backendUrl,
                HttpMethod.GET,
                null,
                Car.class
            );


            Car fetchedCar = response.getBody();
            if (fetchedCar != null) {
                model.addAttribute("car", fetchedCar); // Add car details to the model
                return "car"; // Render car.html template
            }
        } catch (HttpClientErrorException.NotFound e) {
            // Backend returns 404 when the car is not found
            model.addAttribute("errorMessage", "Enter a valid registration number");
        } catch (Exception e) {
            // Handle unexpected errors
            model.addAttribute("errorMessage", "An unexpected error occurred: " + e.getMessage());
        }

        return "search-car"; // Stay on the search page with the error message

    }


}
