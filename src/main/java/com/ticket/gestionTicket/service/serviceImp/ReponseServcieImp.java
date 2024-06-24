package com.ticket.gestionTicket.service.serviceImp;

import com.ticket.gestionTicket.modele.Reponse;
import com.ticket.gestionTicket.repository.ReponseRepository;
import com.ticket.gestionTicket.service.service.ReponseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReponseServcieImp implements ReponseService {

    private final ReponseRepository reponseRepository;


    @Override
    public Reponse creerReponse(Reponse reponse) {
        return reponseRepository.save(reponse);
    }

    @Override
    public List<Reponse> list() {
        return reponseRepository.findAll();
    }

    @Override
    public Reponse modifier(Long id, Reponse reponse) {
        return reponseRepository.findById(id)
                .map(p->{
                    p.setReponse(reponse.getReponse());
                    p.setCommentaire(reponse.getCommentaire());
                    p.setDateEnvoie(reponse.getDateEnvoie());
                    p.setIdFormateur(reponse.getIdFormateur());
                    return reponseRepository.save(p);
                }).orElseThrow(()->new RuntimeException("Reponse not found"));
    }

    @Override
    public String supprimer(Long id) {
        reponseRepository.deleteById(id);
        return "reponse supprimer";
    }
}
