package com.ticket.gestionTicket.service.service;
import com.ticket.gestionTicket.modele.Categorie;

import java.util.List;

public interface CategorieService {

    Categorie creer(Categorie categorie);
    Categorie modifier(Long id, Categorie categorie);
    List<Categorie> list();
    String supprimer(Long id);
}
