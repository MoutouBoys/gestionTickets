package com.ticket.gestionTicket.repository;

import com.ticket.gestionTicket.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByEmail(String email);
    Optional<Utilisateur> findByNom(String nom);
}
