package com.ticket.gestionTicket.service.service;

import com.ticket.gestionTicket.modele.BaseConnaissance;

import java.util.List;

public interface BaseConnaissanceService {
    BaseConnaissance creer(BaseConnaissance baseConnaissance);
    List<BaseConnaissance> list();
    BaseConnaissance modifier(Long id, BaseConnaissance baseConnaissance);
    String supprimer(Long id);
}
