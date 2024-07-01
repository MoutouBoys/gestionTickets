package com.ticket.gestionTicket.controller;

import com.ticket.gestionTicket.modele.Notification;
import com.ticket.gestionTicket.service.service.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/notification")
@AllArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @Operation(summary = "Lire toutes les notifications", description = "Récupère une liste de toutes les notifications.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des notification récupérée avec succès")
    })
    @PostMapping("/create")
    public Notification create(@RequestBody Notification notification) {
        notification.setDateEvoie(new Date());
        return notificationService.create(notification);
    }

    @Operation(summary = "Mettre à jour un notification", description = "Met à jour les informations d'un notification existant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "notification mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "notification non trouvée")
    })
    @PutMapping("/update/{id}")
    public Notification update(@PathVariable Long id, @RequestBody Notification notification) {
        return notificationService.modifier(id,notification);
    }

    @Operation(summary = "Lire toutes les notifications", description = "Récupère une liste de toutes les notifications.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des notification récupérée avec succès")
    })
    @GetMapping("/read")
    public List<Notification> read(){
        return notificationService.lire();
    }

    @Operation(summary = "Supprimer une notification", description = "Supprime une notification par ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "notification supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "notification non trouvée")
    })
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return notificationService.supprimer(id);
    }


}
