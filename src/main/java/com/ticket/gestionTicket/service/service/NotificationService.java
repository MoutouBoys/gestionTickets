package com.ticket.gestionTicket.service.service;

import com.ticket.gestionTicket.modele.Notification;

import java.util.List;

public interface NotificationService {
    Notification create(Notification create);
    Notification modifier(Long id,Notification update);
    List<Notification> lire();
    String supprimer(Long id);
}
