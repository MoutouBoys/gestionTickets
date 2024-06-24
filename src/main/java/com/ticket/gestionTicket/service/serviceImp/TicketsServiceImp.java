package com.ticket.gestionTicket.service.serviceImp;

import com.ticket.gestionTicket.modele.Tickets;
import com.ticket.gestionTicket.repository.TicketRepository;
import com.ticket.gestionTicket.service.service.TicketsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
public class TicketsServiceImp implements TicketsService {
    private final TicketRepository ticketRepository;
    @Override
    public Tickets creer(Tickets tickets) {
        tickets.setDateEnvoie(new Date());
        return ticketRepository.save(tickets);
    }

    @Override
    public Tickets modifier(Long id, Tickets tickets) {
        return ticketRepository.findById(id)
                .map(p-> {
                    p.setTicketEnvoyer(tickets.getTicketEnvoyer());
                    p.setStatus(tickets.getStatus());
                    p.setDateEnvoie(tickets.getDateEnvoie());
                    p.setIdUtilisateur(tickets.getIdUtilisateur());
                    return ticketRepository.save(p);
                }).orElseThrow(()->new RuntimeException("Tickets n'existe pas!"));
    }

    @Override
    public List<Tickets> lire() {
        return ticketRepository.findAll();
    }

    @Override
    public String supprimer(Long id) {
        ticketRepository.deleteById(id);
        return "Ticket Supprimer";
    }
}
