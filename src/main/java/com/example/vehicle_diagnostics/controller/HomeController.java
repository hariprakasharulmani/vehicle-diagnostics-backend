package com.example.vehicle_diagnostics.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Vehicle Diagnostics API is running 🚀";
    }
}
