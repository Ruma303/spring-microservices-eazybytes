package com.eazybytes.accounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccountsController {
    /**
     * This method returns a greeting message.
     *
     * @return A string containing "Hello, World!"
     */
    @GetMapping("/hello")
    public String sayHello() {
        // Return a simple greeting message
        return "Hello, World!";
    }
}
