package com.example.springboot.hi.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hiService")
public class HiController {

    @GetMapping("/sayHiTo/{name}")
    public String sayHi(@PathVariable String name) {
        return "Hi "+name;
    }
}
