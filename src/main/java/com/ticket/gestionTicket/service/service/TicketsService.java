package com.ticket.gestionTicket.service.service;

import com.ticket.gestionTicket.modele.Categorie;
import com.ticket.gestionTicket.modele.Tickets;

import java.util.List;

public interface TicketsService {
    Tickets creer(Tickets tickets);
    Tickets modifier(Long id, Tickets tickets);
    List<Tickets> lire();
    String supprimer(Long id);
    List<Tickets> searchTickets(Categorie query);
    Tickets prendreEnCharge(Long id);
    Tickets resoudre(Long id, String reponse);
}
