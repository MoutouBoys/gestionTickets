package com.ticket.gestionTicket.service.serviceImp;

import com.ticket.gestionTicket.modele.Apprenant;
import com.ticket.gestionTicket.repository.ApprenantRepository;
import com.ticket.gestionTicket.service.service.ApprenantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApprenantServiceImp implements ApprenantService {
    private final ApprenantRepository apprenantRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Apprenant creer(Apprenant apprenant) {
        apprenant.setMotDePasse(passwordEncoder.encode(apprenant.getMotDePasse()));
        return apprenantRepository.save(apprenant);
    }

    @Override
    public Apprenant modifier(Long id, Apprenant apprenant) {
        return apprenantRepository.findById(id)
                .map(p ->{
                    p.setNom(apprenant.getNom());
                    p.setEmail(apprenant.getEmail());
                    p.setMotDePasse(passwordEncoder.encode(apprenant.getMotDePasse()));
                    p.setRole(apprenant.getRole());
                    p.setNiveau(apprenant.getNiveau());
                    p.setProgres(apprenant.getProgres());
                    p.setTicketsSoumis(apprenant.getTicketsSoumis());
                    return apprenantRepository.save(p);
                }).orElseThrow(()->new RuntimeException("Apprenant n'existe pas!"));
    }

    @Override
    public List<Apprenant> lire() {
        return apprenantRepository.findAll();
    }

    @Override
    public String supprimer(Long id) {
        apprenantRepository.deleteById(id);
        return "Apprenant Supprimer";
    }
}
