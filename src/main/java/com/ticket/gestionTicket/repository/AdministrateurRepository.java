package com.ticket.gestionTicket.repository;

import com.ticket.gestionTicket.modele.Administrateur;
import com.ticket.gestionTicket.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {
    Utilisateur findByEmail(String email);
}
