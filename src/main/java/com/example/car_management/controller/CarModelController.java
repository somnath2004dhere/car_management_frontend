package com.example.car_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarModelController {

    @GetMapping("/car-model")
    public String carModelPage() {
        return "car-model"; // Thymeleaf will look for car-model.html in the templates folder
    }
}