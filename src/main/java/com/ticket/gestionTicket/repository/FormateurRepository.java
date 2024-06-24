package com.ticket.gestionTicket.repository;

import com.ticket.gestionTicket.modele.Formateur;
import com.ticket.gestionTicket.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormateurRepository extends JpaRepository<Formateur, Long> {
    Utilisateur findByEmail(String email);
}
