package com.example.car_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String showHomePage() {

        return "home-page"; 
    }

   
    @GetMapping("/about")
    public String showAboutPage() {
        return "about"; 
    }

    @GetMapping("/contact")
    public String showContactPage() {
        return "contact"; 

    }
}
