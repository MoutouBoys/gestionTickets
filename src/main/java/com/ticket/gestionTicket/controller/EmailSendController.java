package com.ticket.gestionTicket.controller;

import com.ticket.gestionTicket.service.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/mail")
public class EmailSendController {
    private EmailService emailService;


    public EmailSendController(EmailService emailService) {
        this.emailService = emailService;
    }
    @Operation(summary = "Créer une nouvelle catégorie", description = "Ajoute une nouvelle sendMail au système.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "sendMail créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide")
    })
    @PostMapping("/send")
    public String sendMail(@RequestParam(value = "file", required = false) MultipartFile[] file, String to, String[] cc, String subject, String body) {
        return emailService.sendMail(file, to, cc, subject, body);
    }

}
