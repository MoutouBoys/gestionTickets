package com.ticket.gestionTicket.controller;

import com.ticket.gestionTicket.modele.BaseConnaissance;
import com.ticket.gestionTicket.service.service.BaseConnaissanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/baseconnaissance")
@AllArgsConstructor
public class BaseConnaissanceController {
    private final BaseConnaissanceService baseConnaissanceService;

    @Operation(summary = "Créer une nouvelle base connaissance", description = "Ajoute une nouvelle base connaissance au système.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "bases connaissance créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide")
    })
    @PostMapping("/create")
    public BaseConnaissance create(@RequestBody BaseConnaissance baseConnaissance) {
        baseConnaissance.setDateEnvoie(new Date());
        return baseConnaissanceService.creer(baseConnaissance);
    }

    @Operation(summary = "Lire toutes les bases connaissance", description = "Récupère une liste de toutes les bases connaissance.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des catégories récupérée avec succès")
    })
    @GetMapping("/read")
    public List<BaseConnaissance> read() {
        return baseConnaissanceService.list();
    }

    @Operation(summary = "Mettre à jour une base connaissance", description = "Met à jour les informations d'un base connaissance existante.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Base connaissance mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Base connaissance non trouvée")
    })
    @PutMapping("/update/{id}")
    public BaseConnaissance update(@PathVariable Long id, @RequestBody BaseConnaissance baseConnaissance) {
        return baseConnaissanceService.modifier(id, baseConnaissance);
    }

    @Operation(summary = "Supprimer un base connaissance", description = "Supprime un base connaissance par ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "base connaissance supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "base connaissance non trouvée")
    })
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return baseConnaissanceService.supprimer(id);
    }
}
