package com.kh.homePageProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/api/message")
    public String getMessage() {
        return "Hello from Spring Boot!";
    }
}