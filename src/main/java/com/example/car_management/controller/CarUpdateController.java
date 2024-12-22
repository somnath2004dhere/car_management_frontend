package com.example.car_management.controller;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
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
    RestTemplate template() {
		return new RestTemplate();
	}
    // Display the car update page
	 @GetMapping("/update-car")
	    public String UpdateCarPage() {
	        return "update"; 
	    }
	 
	 
    @GetMapping("/update")
    public String showUpdateCarPage(@RequestParam String registrationNumber, Model model) {
    	try {
    	String url = "http://localhost:8000/getCar/registrationnumber/" + registrationNumber;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		

		ResponseEntity<Car> response = template().exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<Car>() {
				});
		Car obj = response.getBody();

		System.out.println(obj);
	
			model.addAttribute("car", obj);
			return "car-update"; 
		} catch(Exception e) {
			model.addAttribute("errorMessage", "No Cars found.");
			return "statuspage";
		}
        
    }
    
    @PostMapping("/update-car")
    public String UpdateCar(@ModelAttribute Car car, Model model) {
        try {
            String url = "http://localhost:8000/updateCar";
            System.out.println(car);
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");

            HttpEntity<Car> request = new HttpEntity<>(car, headers);
            ResponseEntity<Car> response = template().exchange(url, HttpMethod.PUT, request, Car.class);

            Car obj = response.getBody();
            model.addAttribute("action", "Updation");
            return "statuspage";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Car not Updated");
            return "statuspage";
        }
    }


}