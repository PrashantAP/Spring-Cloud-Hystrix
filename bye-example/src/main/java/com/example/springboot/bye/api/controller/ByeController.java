package com.example.springboot.bye.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/byeService")
public class ByeController {

    @GetMapping("/sayByeTo/{name}")
    public String sayBye(@PathVariable String name) {
        return "Bye "+name;
    }
}
