package com.ticket.gestionTicket.controller;

import com.ticket.gestionTicket.modele.Formateur;
import com.ticket.gestionTicket.service.service.FormateurService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formateur")
@AllArgsConstructor
public class FormateurController {
    private final FormateurService formateurService;

    @Operation(summary = "Créer un nouveau formateur", description = "Ajoute une nouveau formateur au système.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "formateur créée avec succès"),
            @ApiResponse(responseCode = "400", description = "formateur invalide")
    })
    @PostMapping("/create")
    public Formateur create(@RequestBody Formateur formateur){
        return formateurService.creer(formateur);
    }

    @Operation(summary = "Lire toutes les formateurs", description = "Récupère une liste de toutes les formateurs.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des formateur récupérée avec succès")
    })
    @GetMapping("/read")
    public List<Formateur> read(){
        return formateurService.lire();
    }

    @Operation(summary = "Mettre à jour un formateur", description = "Met à jour les informations d'un formateur existant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "formateur mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "formateur non trouvée")
    })
    @PutMapping("/update/{id}")
    public Formateur update(@PathVariable Long id, @RequestBody Formateur formateur){
        return formateurService.modifier(id, formateur);
    }

    @Operation(summary = "Supprimer un formateur", description = "Supprime un formateur par ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "formateur supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "formateur non trouvée")
    })
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return formateurService.supprimer(id);
    }
}
