package com.ticket.gestionTicket.service.serviceImp;

import com.ticket.gestionTicket.modele.Notification;
import com.ticket.gestionTicket.modele.Tickets;
import com.ticket.gestionTicket.modele.Utilisateur;
import com.ticket.gestionTicket.repository.NotificationRepository;
import com.ticket.gestionTicket.service.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class NotificationServiceImp implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final EmailServiceImpl emailServiceImpl;

    @Override
    public Notification create(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification modifier(Long id, Notification notification) {
        return notificationRepository.findById(id)
                .map(p->{
                    p.setMessage(notification.getMessage());
                    p.setIdUtilisateur(notification.getIdUtilisateur());
                    p.setDateEvoie(notification.getDateEvoie());

                    return notificationRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Erreur d'envoie de notification"));
    }

    @Override
    public List<Notification> lire() {
        return notificationRepository.findAll();
    }

    @Override
    public String supprimer(Long id) {
        notificationRepository.deleteById(id);
        return "Notification supprimer";
    }
    /*public void envoyerNotification(Tickets tickets, Utilisateur utilisateur, String message){
        //Créer et enregistrer la notification dans la base de données;
        Notification notification = new Notification();

        notification.setMessage(message);
        notification.setTicket(tickets);
        notification.setUtilisateur(utilisateur);
        notification.setDateEvoie(new Date());

        notificationRepository.save(notification);

        //Envoie de l'email

        emailServiceImpl.sendSimpleMail(utilisateur.getEmail(), "Notification de ticket", message);
        notificationRepository.save(notification);
    }*/
}
