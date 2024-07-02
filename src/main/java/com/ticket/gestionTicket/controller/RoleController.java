package com.ticket.gestionTicket.controller;

import com.ticket.gestionTicket.modele.Role;
import com.ticket.gestionTicket.service.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@AllArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @Operation(summary = "Lire toutes les rôles", description = "Récupère une liste de toutes les rôles.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des rôles récupérée avec succès")
    })
    @PostMapping("/create")
    public Role create(@RequestBody Role role){
        return roleService.creer(role);
    }


    @Operation(summary = "Lire toutes les reponses", description = "Récupère une liste de toutes les reponses.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des reponses récupérée avec succès")
    })
    @GetMapping("/read")
    public List<Role> read(){
        return roleService.lire();
    }

    @Operation(summary = "Mettre à jour d'une rôle", description = "Met à jour les informations d'une rôle existant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "rôle mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "rôle non trouvée")
    })
    @PutMapping("/update/{id}")
    public Role update(@PathVariable Long id, @RequestBody Role role){
        return roleService.modifier(id, role);
    }

    @Operation(summary = "Supprimer une rôle", description = "Supprime une rôle par ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "rôle supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "rôle non trouvée")
    })
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return roleService.supprimer(id);
    }
}
