package com.ticket.gestionTicket.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthAndSecurityController {

    @Operation(summary = "Envoyer une notification", description = "Envoyer une notification à un apprenant spécifique.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "notification envoyer avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide")
    })
    @GetMapping("/hello")
    public String hello() {
        return "Hello, authenticated user!";
    }
}
