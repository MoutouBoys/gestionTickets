package com.ticket.gestionTicket.service.serviceImp;

import com.ticket.gestionTicket.modele.Formateur;
import com.ticket.gestionTicket.repository.FormateurRepository;
import com.ticket.gestionTicket.service.service.FormateurService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FormateurServiceImp implements FormateurService {

    private final FormateurRepository formateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Formateur creer(Formateur formateur) {
        formateur.setMotDePasse(passwordEncoder.encode(formateur.getMotDePasse()));
        return formateurRepository.save(formateur);
    }

    @Override
    public Formateur modifier(Long id, Formateur formateur) {
        return formateurRepository.findById(id)
                .map(p ->{
                    p.setNom(formateur.getNom());
                    p.setEmail(formateur.getEmail());
                    p.setMotDePasse(passwordEncoder.encode(formateur.getMotDePasse()));
                    p.setRole(formateur.getRole());
                    p.setSpecialisation(formateur.getSpecialisation());
                    p.setTicketsAssignes(formateur.getTicketsAssignes());
                    p.setEvaluations(formateur.getEvaluations());
                    return formateurRepository.save(p);
                }).orElseThrow(()->new RuntimeException("Formateur n'existe pas!"));
    }

    @Override
    public String supprimer(Long id) {
         formateurRepository.deleteById(id);
        return "Formateur supprimer";
    }

    @Override
    public List<Formateur> lire() {
        return formateurRepository.findAll();
    }
}
