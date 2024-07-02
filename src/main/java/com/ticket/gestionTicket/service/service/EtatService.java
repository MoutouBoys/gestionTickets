package com.ticket.gestionTicket.service.service;
import com.ticket.gestionTicket.modele.Etat;
import java.util.List;

public interface EtatService {

    Etat creer(Etat etat);
    Etat modifier(Long id, Etat etat);
    List<Etat> lire();
    String supprimer(Long id);

    Etat getEtatOuvert();
    Etat getEtatEncours();
    Etat getEtatResolu();
}
