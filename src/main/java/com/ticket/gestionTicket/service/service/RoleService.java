package com.ticket.gestionTicket.service.service;

import com.ticket.gestionTicket.modele.Role;

import java.util.List;

public interface RoleService {
    Role creer(Role role);
    List<Role> lire();
    String supprimer(Long id);
    Role modifier(Long id, Role role);
}
