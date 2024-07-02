package com.ticket.gestionTicket.controller;

import com.ticket.gestionTicket.modele.Apprenant;
import com.ticket.gestionTicket.service.service.ApprenantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apprenant")
@AllArgsConstructor
public class ApprenantController {
    private  final ApprenantService apprenantService;

    @Operation(summary = "Créer une nouvelle apprenant", description = "Ajoute une nouvelle apprenant au système.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "apprenant créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide")
    })
    @PostMapping("/create")
    public Apprenant create(@RequestBody Apprenant apprenant){
        //apprenant.setMotDePasse( PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(apprenant.getMotDePasse()));
        return apprenantService.creer(apprenant);
    }

    @Operation(summary = "Lire toutes les apprenants", description = "Récupère une liste de toutes les apprenants.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des catégories récupérée avec succès")
    })
    @GetMapping("/read")
    public List<Apprenant> read(){
        return apprenantService.lire();
    }

    @Operation(summary = "Mettre à jour une apprenant", description = "Met à jour les informations d'un apprenant existante.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "apprenant mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "apprenant non trouvée")
    })
    @PutMapping("/update/{id}")
    public Apprenant update(@PathVariable Long id, @RequestBody Apprenant apprenant){
        return apprenantService.modifier(id,apprenant);
    }

    @Operation(summary = "Supprimer un apprenant", description = "Supprime un apprenant par ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "apprenant supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "apprenant non trouvée")
    })
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return apprenantService.supprimer(id);
    }
}
