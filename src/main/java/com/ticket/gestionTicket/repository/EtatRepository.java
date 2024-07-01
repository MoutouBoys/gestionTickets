package com.ticket.gestionTicket.repository;

import com.ticket.gestionTicket.modele.Etat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EtatRepository extends JpaRepository<Etat, Long> {
    Optional<Etat> findByLibelle(String libelle);

}
