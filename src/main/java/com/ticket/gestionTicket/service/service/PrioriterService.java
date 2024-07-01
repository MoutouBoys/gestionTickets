package com.ticket.gestionTicket.service.service;

import com.ticket.gestionTicket.modele.Prioriter;

import java.util.List;

public interface PrioriterService {

    Prioriter creer(Prioriter prioriter);
    List<Prioriter> list();
    Prioriter modifier(Long id, Prioriter prioriter);
    String supprimer(Long id);
}
