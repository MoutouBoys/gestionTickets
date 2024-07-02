package com.ticket.gestionTicket.repository;

import com.ticket.gestionTicket.modele.Categorie;
import com.ticket.gestionTicket.modele.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Tickets, Long> {
    List<Tickets> findByCategorie(Categorie categorie);
}
