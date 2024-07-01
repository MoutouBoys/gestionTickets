package com.ticket.gestionTicket.controller;

import com.ticket.gestionTicket.modele.Reponse;
import com.ticket.gestionTicket.service.service.ReponseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reponse")
@AllArgsConstructor
public class ReponseController {
    private final ReponseService reponseService;

    @Operation(summary = "Lire toutes les reponses", description = "Récupère une liste de toutes les reponse.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des reponses récupérée avec succès")
    })
    @PostMapping("/create")
    public Reponse creerReponse(@RequestBody Reponse reponse) {
        return reponseService.creerReponse(reponse);
    }

    @Operation(summary = "Mettre à jour d'une reponse", description = "Met à jour les informations d'une reponse existant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "reponse mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "reponse non trouvée")
    })
    @GetMapping("/read")
    public List<Reponse> read(){
        return reponseService.list();
    }

    @Operation(summary = "Lire toutes les reponses", description = "Récupère une liste de toutes les reponses.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des reponses récupérée avec succès")
    })
    @PutMapping("/update/{id}")
    public Reponse update(@PathVariable Long id, @RequestBody Reponse reponse){
        return reponseService.modifier(id, reponse);
    }

    @Operation(summary = "Supprimer une reponse", description = "Supprime une reponse par ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "reponse supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "reponse non trouvée")
    })
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return reponseService.supprimer(id);
    }
}
