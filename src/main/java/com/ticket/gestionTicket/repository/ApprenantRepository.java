package com.ticket.gestionTicket.repository;

import com.ticket.gestionTicket.modele.Apprenant;
import com.ticket.gestionTicket.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprenantRepository extends JpaRepository<Apprenant, Long>{
    Utilisateur findByEmail(String email);
}
