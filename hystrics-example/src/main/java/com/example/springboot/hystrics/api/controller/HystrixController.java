package com.example.springboot.hystrics.api.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HystrixController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(groupKey = "PrashantP", commandKey = "PrashantP",
    fallbackMethod = "fallBack"
    )
    @GetMapping("/service-api-withHystrix")
    public String servicesWithHystrix() {

        System.out.println("Calling servicesWithHystrix...");

        String hiURL = "http://localhost:8181/hiService/sayHiTo/prashant";
        String byeURL = "http://localhost:8282/byeService/sayByeTo/Jack";

        String hiResponse = restTemplate.getForObject(hiURL, String.class);
        String byeResponse = restTemplate.getForObject(byeURL, String.class);

        return hiResponse + "\n" + byeResponse;
    }

    @GetMapping("/service-api-withoutHystrix")
    public String servicesWithoutHystrix() {

        System.out.println("Calling servicesWithoutHystrix...");

        String hiURL = "http://localhost:8181/hiService/sayHiTo/prashant";
        String byeURL = "http://localhost:8282/byeService/sayByeTo/Jack";

        String hiResponse = restTemplate.getForObject(hiURL, String.class);
        String byeResponse = restTemplate.getForObject(byeURL, String.class);

        return hiResponse + "\n" + byeResponse;
    }

    public String fallBack() {
        return "service unavailable...";
    }
}
