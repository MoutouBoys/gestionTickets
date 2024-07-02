package com.ticket.gestionTicket.service.serviceImp;

import com.ticket.gestionTicket.modele.BaseConnaissance;
import com.ticket.gestionTicket.repository.BaseConnaissanceRepository;
import com.ticket.gestionTicket.service.service.BaseConnaissanceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BaseConnaissanceImp implements BaseConnaissanceService {
    private final BaseConnaissanceRepository baseConnaissanceRepository;

    @Override
    public BaseConnaissance creer(BaseConnaissance baseConnaissance){
        return baseConnaissanceRepository.save(baseConnaissance);
    }

    @Override
    public List<BaseConnaissance> list() {
        return baseConnaissanceRepository.findAll();
    }

    @Override
    public BaseConnaissance modifier(Long id, BaseConnaissance baseConnaissance) {
        return baseConnaissanceRepository.findById(id)
                .map(p->{
                    p.setQuestion(baseConnaissance.getQuestion());
                    p.setReponse(baseConnaissance.getReponse());
                    p.setIdFormateur(baseConnaissance.getIdFormateur());
                    p.setDateEnvoie(baseConnaissance.getDateEnvoie());
                    p.setLien(baseConnaissance.getLien());
                    p.setPieceJointe(baseConnaissance.getPieceJointe());
                    return p;
                }).orElseThrow(()->new RuntimeException("Erreur de modification"));
    }

    @Override
    public String supprimer(Long id) {
        baseConnaissanceRepository.deleteById(id);
        return "Donnée supprimer";
    }
}
