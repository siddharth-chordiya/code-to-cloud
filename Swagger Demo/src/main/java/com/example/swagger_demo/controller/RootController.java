package com.example.swagger_demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("health")
    public String healthCheck() {

        System.out.println("log : Service is Up");
        return "Service is UP";
    }

    @GetMapping("test")
    public String test() {

        System.out.println("log : Test log");
        return "Service is UP";
    }

}
