package com.ticket.gestionTicket.repository;

import com.ticket.gestionTicket.modele.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Tickets, Long> {
}
