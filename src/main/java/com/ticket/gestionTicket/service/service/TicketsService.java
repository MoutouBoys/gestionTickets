package com.ticket.gestionTicket.service.service;

import com.ticket.gestionTicket.modele.Tickets;

import java.util.List;

public interface TicketsService {
    Tickets creer(Tickets tickets);
    Tickets modifier(Long id, Tickets tickets);
    List<Tickets> lire();
    String supprimer(Long id);
}
