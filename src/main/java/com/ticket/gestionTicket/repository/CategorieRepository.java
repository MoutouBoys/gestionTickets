package com.ticket.gestionTicket.repository;

import com.ticket.gestionTicket.modele.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
//    Optional<Categorie> findByCategorie(Long categorie);
}
