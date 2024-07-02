package com.ticket.gestionTicket.controller;

import com.ticket.gestionTicket.modele.Administrateur;
import com.ticket.gestionTicket.service.service.AdministrateurService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrateur")
@AllArgsConstructor

public class AdministrateurController {
    private final AdministrateurService administrateurService;

    @Operation(summary = "Création administrateurs", description = "créer un ou des tickets")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "administrateurs créer avec succès"),
            @ApiResponse(responseCode = "404", description = "Non autoriser à créer des administrateurs")
    })
    @PostMapping("/create")
    public Administrateur create(@RequestBody Administrateur administrateur){
        return administrateurService.creer(administrateur);
    }

    @Operation(summary = "Lire toutes les Administrateurs", description = "Récupère une liste de toutes les Administrateurs.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des Administrateurs récupérée avec succès")
    })
    @GetMapping("/read")
    public List<Administrateur> read(){
        return administrateurService.lire();
    }

    @Operation(summary = "Mettre à jour un Administrateur", description = "Met à jour les informations d'un Administrateur existante.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Administrateur mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Administrateur non trouvée")
    })

    @PutMapping("/update/{id}")
    public Administrateur update(@PathVariable Long id, @RequestBody Administrateur administrateur){
        return administrateurService.modifier(id, administrateur);
    }

    @Operation(summary = "Supprimer un Administrateur", description = "Supprime un Administrateur par ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Administrateur supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Administrateur non trouvée")
    })
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return administrateurService.supprimer(id);
    }
}
