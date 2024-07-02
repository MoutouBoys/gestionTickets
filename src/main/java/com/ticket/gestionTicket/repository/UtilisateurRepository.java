package com.ticket.gestionTicket.repository;

import com.ticket.gestionTicket.modele.Role;
import com.ticket.gestionTicket.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByEmail(String email);
    List<Utilisateur> findAllByRole(Role role);
    List<Utilisateur> findByNomContainingOrEmailContaining(String nom, String email);
}
