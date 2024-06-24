package com.ticket.gestionTicket.service.service;

import com.ticket.gestionTicket.modele.Apprenant;

import java.util.List;

public interface ApprenantService {
    Apprenant creer(Apprenant apprenant);
    Apprenant modifier(Long id, Apprenant apprenant);
    List<Apprenant> lire();
    String supprimer(Long id);
}
