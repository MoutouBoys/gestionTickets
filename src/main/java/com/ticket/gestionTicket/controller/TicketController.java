package com.ticket.gestionTicket.controller;

import com.ticket.gestionTicket.modele.Apprenant;
import com.ticket.gestionTicket.modele.Tickets;
import com.ticket.gestionTicket.service.service.TicketsService;
import com.ticket.gestionTicket.service.serviceImp.EmailServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@AllArgsConstructor
@Tag(name = "Ticket Management System", description = "Operations pertaining to tickets in Ticket Management System")
public class TicketController {
    private final TicketsService ticketsService;
    private final EmailServiceImpl emailService;

    @PostMapping("/create")
    public Tickets Create(@RequestBody Tickets tickets, Apprenant apprenant){
        //emailService.SendSimpleMail(apprenant.getEmail(), "Message à", apprenant.getNom());
        return ticketsService.creer(tickets);
    }

    @Operation(summary = "View a list of available tickets", description = "Retrieve a list of all tickets")
    @GetMapping("/read")
    public List<Tickets> read(){
        return ticketsService.lire();
    }

    @PutMapping("/update/{id}")
    public Tickets update(@PathVariable Long id, @RequestBody Tickets tickets){
        return ticketsService.modifier(id, tickets);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return ticketsService.supprimer(id);
    }
}
