package com.ticket.gestionTicket.service.serviceImp;

import com.ticket.gestionTicket.modele.Role;
import com.ticket.gestionTicket.repository.RoleRepository;
import com.ticket.gestionTicket.service.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImp implements RoleService {
    private RoleRepository roleRepository;

    @Override
    public Role creer(Role role) {
        return roleRepository.save(role);
    }
    @Override
    public List<Role> lire() {
        return roleRepository.findAll();
    }
    @Override
    public Role modifier(Long id, Role role) {
        return roleRepository.findById(id)
                .map(p->{
                    p.setLibelle(role.getLibelle());

                    return roleRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Erreur de modification"));
    }
    @Override
    public String supprimer(Long id) {
        roleRepository.deleteById(id);
        return "Role supprimer";
    }
}
