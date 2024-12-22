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
    RestTemplate restTemplate() {
		return new RestTemplate();
	}

    @GetMapping("/car-register")
    public String showCarRegisterPage(Model model) {
        // Returns the name of the Thymeleaf template without the ".html" extension
    	model.addAttribute("car", new Car());
        return "car-register";
    }
    
    @PostMapping("/register")
    public String submitCarForm(@ModelAttribute Car car, Model model) {
    	try {
    	String url = "http://localhost:8000/addCar";
       System.out.println(car);
		// header is used to set data in json

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");

		// send request to one application to other application
		HttpEntity<Car> request = new HttpEntity<>(car, headers);// employee obj

		// Send the POST request
//	        try {
		ResponseEntity<Car> response = restTemplate().exchange(url, HttpMethod.POST, request, Car.class);

		// REQUST TO GET THE RESPONCE
		Car obj = null;
		obj = response.getBody();// ACESS THE RESPONCE

//	        }
//	        catch(HttpClientErrorException e) {
//	        	      	
//	        	ObjectMapper objectMapper = new ObjectMapper();
//	            JsonNode rootNode = objectMapper.readTree(e.getResponseBodyAsString());
//	            String errorMessage = rootNode.path("message").asText();
//	        	model.addAttribute("errorMessage", errorMessage);
//	        		return "statuspage";
//	       }

		
			model.addAttribute("action", "Registration");
			return "statuspage";
		}
		catch(Exception e) {
			model.addAttribute("errorMessage", "Car not added to the database");
			return "statuspage";
		}
      
    }
}