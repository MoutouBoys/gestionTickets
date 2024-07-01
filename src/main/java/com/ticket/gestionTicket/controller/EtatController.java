package com.ticket.gestionTicket.controller;

import com.ticket.gestionTicket.modele.Etat;
import com.ticket.gestionTicket.modele.Role;
import com.ticket.gestionTicket.service.service.EtatService;
import com.ticket.gestionTicket.service.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etat")
@AllArgsConstructor
public class EtatController {
    private final EtatService etatService;

    @Operation(summary = "Créer une nouvelle etat", description = "Ajoute une nouvelle etat au système.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "etat créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide")
    })
    @PostMapping("/create")
    public Etat create(@RequestBody Etat etat){
        return etatService.creer(etat);
    }

    @Operation(summary = "Lire toutes les etats", description = "Récupère une liste de toutes les etats.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des etats récupérée avec succès")
    })
    @GetMapping("/read")
    public List<Etat> read(){
        return etatService.lire();
    }

    @Operation(summary = "Mettre à jour un etat", description = "Met à jour les informations d'un etat existant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "etat mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "etat non trouvée")
    })
    @PutMapping("/update/{id}")
    public Etat update(@PathVariable Long id, @RequestBody Etat etat){
        return etatService.modifier(id, etat);
    }

    @Operation(summary = "Supprimer un etat", description = "Supprime un etat par ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "etat supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "etat non trouvée")
    })
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return etatService.supprimer(id);
    }
}
