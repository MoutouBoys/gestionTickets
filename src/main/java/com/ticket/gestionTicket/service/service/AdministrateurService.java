package com.ticket.gestionTicket.service.service;

import com.ticket.gestionTicket.modele.Administrateur;

import java.util.List;

public interface AdministrateurService {
    Administrateur creer(Administrateur administrateur);
    List<Administrateur> lire();
    Administrateur modifier(Long id, Administrateur administrateur);
    String supprimer(Long id);
}
