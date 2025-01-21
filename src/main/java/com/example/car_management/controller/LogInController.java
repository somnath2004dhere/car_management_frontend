package com.example.car_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogInController {
	
	@GetMapping("/log-in-u")
    public String showLogInPage() {
        return "userLogIn"; 
    }
	
	@GetMapping("/log-in-A")
    public String showALogInPage() {
        return "AdminLogIn"; 
    }


}
