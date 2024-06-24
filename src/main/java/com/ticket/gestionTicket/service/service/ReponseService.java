package com.ticket.gestionTicket.service.service;

import com.ticket.gestionTicket.modele.Reponse;

import java.util.List;

public interface ReponseService {
    Reponse creerReponse(Reponse reponse);
    List<Reponse> list();
    Reponse modifier(Long id, Reponse reponse);
    String supprimer(Long id);
}
