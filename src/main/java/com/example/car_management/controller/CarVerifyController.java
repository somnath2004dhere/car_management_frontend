package com.example.car_management.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.car_management.model.Car;

@Configuration
@Controller
public class CarVerifyController {

    // Display the car update page
	@Bean
    RestTemplate templateGet() {
		return new RestTemplate();
	}
    @GetMapping("/search-car")
    public String showCar() {
        return "reg-verify"; 
    }
    
    @GetMapping("/getCar")
    public String getCar(@RequestParam String registrationNumber, Model model) {
    	try {
        	String url = "http://localhost:8000/getCar/registrationnumber/" + registrationNumber;
    		HttpHeaders headers = new HttpHeaders();
    		headers.set("Content-Type", "application/json");
    		

    		ResponseEntity<Car> response = templateGet().exchange(url, HttpMethod.GET, null,
    				new ParameterizedTypeReference<Car>() {
    				});
    		Car obj = response.getBody();

    		System.out.println(obj);
    	
    			model.addAttribute("car", obj);
    			return "car"; 
    		} catch(Exception e) {
    			model.addAttribute("errorMessage", "No Cars found.");
    			return "statuspage";
    		}
    }

}