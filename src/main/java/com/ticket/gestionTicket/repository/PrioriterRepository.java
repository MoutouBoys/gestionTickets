package com.ticket.gestionTicket.repository;

import com.ticket.gestionTicket.modele.Prioriter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrioriterRepository extends JpaRepository<Prioriter, Long> {
    Optional<Prioriter> findByLibelle(String prioriterLibelle);
}
