package com.ticket.gestionTicket.service.service;

import com.ticket.gestionTicket.modele.Formateur;

import java.util.List;

public interface FormateurService {
    Formateur creer(Formateur formateur);
    Formateur modifier(Long id, Formateur formateur);
    String supprimer(Long id);
    List<Formateur> lire();
}
