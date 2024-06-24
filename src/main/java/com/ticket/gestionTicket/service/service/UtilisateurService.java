package com.ticket.gestionTicket.service.service;

import com.ticket.gestionTicket.modele.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    Utilisateur creer(Utilisateur user);
    List<Utilisateur> lire();
    Utilisateur modifier(Long id, Utilisateur user);
    String supprimer(Long id);
}
