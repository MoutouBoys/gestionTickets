package com.ticket.gestionTicket.service.serviceImp;

import com.ticket.gestionTicket.modele.Etat;
import com.ticket.gestionTicket.repository.EtatRepository;
import com.ticket.gestionTicket.service.service.EtatService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EtatServiceImp implements EtatService {

    private final EtatRepository etatRepository;
    @Override
    public Etat creer(Etat etat) {
        return etatRepository.save(etat);
    }

    @Override
    public Etat modifier(Long id, Etat etat) {
        return etatRepository.findById(id)
                .map(p->{
                    p.setDescription(etat.getDescription());
                    p.setLibelle(etat.getLibelle());

                    return etatRepository.save(p);
                }).orElseThrow(()->new RuntimeException("Erreur de modification"));
    }

    @Override
    public List<Etat> lire() {
        return etatRepository.findAll();
    }

    @Override
    public String supprimer(Long id) {
        etatRepository.deleteById(id);
        return "Etat supprimer";
    }

    public Etat getEtatOuvert(){
        return etatRepository.findByLibelle("ouvert")
                .orElseThrow(()->new RuntimeException("L'etat 'ouvert' n'existe pas dans la base"));
    }

    public Etat getEtatEncours(){
        return etatRepository.findByLibelle("en cours")
                .orElseThrow(()->new RuntimeException("L'etat 'en cours' n'existe pas dans la base"));
    }

    public Etat getEtatResolu(){
        return etatRepository.findByLibelle("resolu")
                .orElseThrow(()->new RuntimeException("L'etat 'resolu' n'existe pas dans la base"));
    }
}
