package com.ticket.gestionTicket.controller;

import com.ticket.gestionTicket.modele.Apprenant;
import com.ticket.gestionTicket.modele.Categorie;
import com.ticket.gestionTicket.modele.Tickets;
import com.ticket.gestionTicket.service.service.TicketsService;
import com.ticket.gestionTicket.service.serviceImp.EmailServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@AllArgsConstructor
@Tag(name = "Ticket Management System", description = "Operations pertaining to tickets in Ticket Management System")
public class TicketController {
    private final TicketsService ticketsService;
    private final EmailServiceImpl emailService;
    private final ReponseController reponseController;

    @Operation(summary = "Soumettre des tickets.", description = "Soumet un ou des tickets")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tickets soumis avec succès"),
            @ApiResponse(responseCode = "404", description = "Non autoriser à soumettre des tickets")
    })
    @PostMapping("/create")
    public Tickets Create(@RequestBody Tickets tickets){
        return ticketsService.creer(tickets);
    }

    @Operation(summary = "Lire tous les tickets.", description = "Récupére une liste de tickets.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des tickets récupérer avec succès"),
            @ApiResponse(responseCode = "404", description = "Tickets non trouvé")
    })
    @GetMapping("/read")
    public List<Tickets> read(){
        return ticketsService.lire();
    }

    @Operation(summary = "Mettre à jour les tickets.", description = "Met à jour un ou tickets.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tickets mis à jour avec succès")
    })
    @PutMapping("/update/{id}")
    public Tickets update(@PathVariable Long id, @RequestBody Tickets tickets){
        return ticketsService.modifier(id, tickets);
    }

    @Operation(summary = "Suppression des tickets.", description = "Supprime un ou des tickets.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tickets supprimer avec succès")
    })
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return ticketsService.supprimer(id);
    }

    @Operation(summary = "Prendre en charge un ticket", description = "Marque un ticket comme pris en charge.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ticket pris en charge avec succès"),
            @ApiResponse(responseCode = "404", description = "Ticket non trouvé")
    })
    @PutMapping("/pris_en_charge/{id}")
    public Tickets prendreEnCharge(@PathVariable Long id) {
        return ticketsService.prendreEnCharge(id);
    }

    @Operation(summary = "Résoudre un ticket", description = "Marque un ticket comme résolu avec une réponse.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Ticket résolu avec succès"),
            @ApiResponse(responseCode = "404", description = "Ticket non trouvé")
    })
    @PutMapping("/resoudre/{id}")
    public Tickets resoudre(@PathVariable Long id, @RequestBody String reponse) {

        return ticketsService.resoudre(id, reponse);
    }

    @GetMapping("/search")
    public List<Tickets> searchTickets(@RequestParam Categorie query){
        return ticketsService.searchTickets(query);
    }
}
