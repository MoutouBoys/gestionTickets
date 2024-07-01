package com.ticket.gestionTicket.service.serviceImp;

import com.ticket.gestionTicket.modele.Categorie;
import com.ticket.gestionTicket.repository.CategorieRepository;
import com.ticket.gestionTicket.service.service.CategorieService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategorieServiceImp implements CategorieService {
    private final CategorieRepository categorieRepository;

    @Override
    public Categorie creer(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie modifier(Long id, Categorie categorie) {
        return categorieRepository.findById(id)
                .map(p->{
                    p.setDescription(categorie.getDescription());
                    p.setLibelle(categorie.getLibelle());

                    return categorieRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Erreur de modification"));
    }

    @Override
    public List<Categorie> list() {
        return categorieRepository.findAll();
    }

    @Override
    public String supprimer(Long id) {
        categorieRepository.deleteById(id);
        return "Categorie supprimer";
    }
}
