package com.ticket.gestionTicket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthAndSecurityController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, authenticated user!";
    }
}
