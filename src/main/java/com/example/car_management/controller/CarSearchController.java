package com.example.car_management.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.example.car_management.model.Car;


@Controller
public class CarSearchController {

	
	  @GetMapping("/filter")
	  public String filter(Model model) {
		  model.addAttribute("cars", new ArrayList<Car>());
		  return "car-filter";
	  }
	  
	 
	  
}
