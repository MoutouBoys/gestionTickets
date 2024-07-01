package com.ticket.gestionTicket.service.serviceImp;

import com.ticket.gestionTicket.modele.Prioriter;
import com.ticket.gestionTicket.repository.PrioriterRepository;
import com.ticket.gestionTicket.service.service.PrioriterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PrioriterServiceImp implements PrioriterService {
    private final PrioriterRepository prioriterRepository;

    @Override
    public Prioriter creer(Prioriter prioriter) {
        return prioriterRepository.save(prioriter);
    }

    @Override
    public List<Prioriter> list() {
        return prioriterRepository.findAll();
    }

    @Override
    public Prioriter modifier(Long id, Prioriter prioriter) {
        return prioriterRepository.findById(id)
                .map(p->{
                    p.setDescription(prioriter.getDescription());
                    p.setLibelle(prioriter.getLibelle());

                    return prioriterRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Erreur de modification"));
    }

    @Override
    public String supprimer(Long id) {
        prioriterRepository.deleteById(id);
        return "Prioriter supprimer";
    }
}
