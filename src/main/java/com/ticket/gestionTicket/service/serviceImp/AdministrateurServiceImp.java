package com.ticket.gestionTicket.service.serviceImp;

import com.ticket.gestionTicket.modele.Administrateur;
import com.ticket.gestionTicket.repository.AdministrateurRepository;
import com.ticket.gestionTicket.service.service.AdministrateurService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdministrateurServiceImp implements AdministrateurService {
    private final AdministrateurRepository administrateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Administrateur creer(Administrateur administrateur) {
        administrateur.setMotDePasse(passwordEncoder.encode(administrateur.getMotDePasse()));
        return administrateurRepository.save(administrateur);
    }

    @Override
    public List<Administrateur> lire() {
        return administrateurRepository.findAll();
    }

    @Override
    public Administrateur modifier(Long id, Administrateur administrateur) {
        return administrateurRepository.findById(id)
                .map(p->{
                    p.setNom(administrateur.getNom());
                    p.setEmail(administrateur.getEmail());
                    p.setMotDePasse(passwordEncoder.encode(administrateur.getMotDePasse()));
                    p.setRole(administrateur.getRole());
                    p.setGestionDesUtilisateurs(administrateur.getGestionDesUtilisateurs());
                    p.setStatistiquesSysteme(administrateur.getStatistiquesSysteme());

                    return administrateurRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("La ligne n'existe pas"));
    }

    @Override
    public String supprimer(Long id) {
        return "Administrateur supprimer";
    }
}
