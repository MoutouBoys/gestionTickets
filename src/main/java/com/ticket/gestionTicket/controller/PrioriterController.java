package com.ticket.gestionTicket.controller;

import com.ticket.gestionTicket.modele.Prioriter;
import com.ticket.gestionTicket.service.service.PrioriterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prioriter")
@AllArgsConstructor
public class PrioriterController {
    private final PrioriterService prioriterService;

    @Operation(summary = "Lire toutes les priorités", description = "Récupère une liste de toutes les priorités.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des priorités récupérée avec succès")
    })
    @PostMapping("/create")
    public Prioriter create(@RequestBody Prioriter prioriter){
            return prioriterService.creer(prioriter);
    }

    @Operation(summary = "Mettre à jour d'une priorité", description = "Met à jour les informations d'une priorité existant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "prioriter mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "prioriter non trouvée")
    })
    @GetMapping("/read")
    public List<Prioriter> read(){
        return prioriterService.list();
    }

    @Operation(summary = "Lire toutes les priorités", description = "Récupère une liste de toutes les priorités.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des priorités récupérée avec succès")
    })
    @PutMapping("/update/{id}")
    public Prioriter update(@PathVariable Long id, @RequestBody Prioriter prioriter){
        return prioriterService.modifier(id, prioriter);
    }

    @Operation(summary = "Supprimer une priorité", description = "Supprime une priorité par ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "prioriter supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "prioriter non trouvée")
    })
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return prioriterService.supprimer(id);
    }
}
