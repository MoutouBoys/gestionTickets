package com.ticket.gestionTicket.controller;

import com.ticket.gestionTicket.modele.Utilisateur;
import com.ticket.gestionTicket.service.service.UtilisateurService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/utilisateur")
@AllArgsConstructor
public class UtilisateurController {
    private final UtilisateurService utilisateurService;

    @Operation(summary = "Lire toutes les utilisateurs", description = "Récupère une liste de toutes les utilisateurs.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des utilisateurs récupérée avec succès")
    })
    @PostMapping("/create")
    public Utilisateur create(@RequestBody Utilisateur user){
        return utilisateurService.creer(user);
    }

    @Operation(summary = "Lire toutes les utilisateurs", description = "Récupère une liste de toutes les utilisateurs.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des utilisateurs récupérée avec succès")
    })
    @GetMapping("/read")
    public List<Utilisateur> read(){
        return utilisateurService.lire();
    }

    @Operation(summary = "Mettre à jour d'un utilisateur", description = "Met à jour les informations d'un utilisateur existant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "utilisateur mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "utilisateur non trouvée")
    })
    @PutMapping("/update/{id}")
    public Utilisateur update(@PathVariable Long id, @RequestBody Utilisateur user){
        return utilisateurService.modifier(id, user);
    }

    @Operation(summary = "Supprimer un utilisateur", description = "Supprime un utilisateur par ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "utilisateur supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "utilisateur non trouvée")
    })
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return utilisateurService.supprimer(id);
    }

    @GetMapping("/users/search")
    public List<Utilisateur> searchUsers(@RequestParam String query) {
        return utilisateurService.searchUsers(query);
    }
}
