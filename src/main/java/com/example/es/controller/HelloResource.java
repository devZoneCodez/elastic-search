package com.example.es.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class HelloResource {

    @GetMapping("hello")
    public String hello() {
        return "<h1>Hello! Welcome to the world....</h1>";
    }
}
