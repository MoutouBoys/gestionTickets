package com.ticket.gestionTicket.service.serviceImp;


import com.ticket.gestionTicket.modele.*;
import com.ticket.gestionTicket.repository.*;
import com.ticket.gestionTicket.service.service.EmailService;
import com.ticket.gestionTicket.service.service.EtatService;
import com.ticket.gestionTicket.service.service.TicketsService;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class TicketsServiceImp implements TicketsService {
    private final UtilisateurRepository utilisateurRepository;
    private final TicketRepository ticketRepository;
    private final PrioriterRepository prioriteRepository;
    private final CategorieRepository categorieRepository;
    private final EtatService etatService;
    private final ReponseRepository reponseRepository;
    private final EmailService emailService;
    private final RoleRepository roleRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Lazy
    @Override
    public Tickets creer(Tickets tickets) {
        tickets.setDateEnvoie(new Date());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Utilisateur apprenant = utilisateurRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé : " + authentication.getName()));
        tickets.setApprenant(apprenant);

// Utilisation de l'utilisateur trouvé dans la suite du traitement
        tickets.setApprenant(apprenant);



        Long prioriteId = (long) tickets.getPrioriter().getId();
        Long categorieId = (long) tickets.getCategorie().getId();

        Prioriter priorite = prioriteRepository.findById(prioriteId)
                .orElseThrow(() -> new RuntimeException("La priorité spécifiée n'existe pas : " + prioriteId));;

                tickets.setPrioriter(priorite);
        Categorie categorie = categorieRepository.findById(categorieId)
                .orElseThrow(() -> new RuntimeException("La catégorie spécifiée n'existe pas : " + categorieId));
        tickets.setCategorie(categorie);

        Etat etatOuvert = etatService.getEtatOuvert();
        tickets.setEtat(etatOuvert);

        Tickets nouveauTicket = ticketRepository.save(tickets);

        Role role = roleRepository.findByLibelle("Formateur");

        List<Utilisateur> formateurs = utilisateurRepository.findAllByRole(role);

        formateurs.forEach(formateur -> {
            String sujet = "Nouveau ticket soumis";
            String corps = "Un nouveau ticket a été soumis par l'apprenant " + apprenant.getUsername()+" " + apprenant.getNom() +".Veuillez le vérifier.";
            emailService.sendSimpleMessage( formateur.getEmail(), sujet, corps);
        });


        //SendSimpleMail("yalcouyemamoutou02@gmail.com","yalcouyemamoutou2@gmail.com","ticket soumis avec succes:","Votre ticket a été soumis avec succès.");
        String sujet = "Nouveau ticket soumis";
        String corps = "Votre ticket a été soumis avec succès. Patientez..";
        emailService.sendSimpleMessage( apprenant.getEmail(), sujet, corps);

        return nouveauTicket;
    }

    @Override
    public Tickets modifier(Long id, Tickets tickets) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String emailUtilisateurConnecte = authentication.getName();
        return ticketRepository.findById(id)
                .map(p-> {
                    Utilisateur proprietaireTicket = p.getApprenant();

                    if (!proprietaireTicket.getEmail().equals(emailUtilisateurConnecte)) {
                        throw new RuntimeException("Vous n'êtes pas autorisé à modifier ce ticket.");
                    }

                    if (p.getEtat().getLibelle().equals("en cours") || p.getEtat().getLibelle().equals("resolu")) {
                        throw new RuntimeException("Ce ticket ne peut plus être modifié.");
                    }

                    p.setDescription(tickets.getDescription());
                    p.setPrioriter(tickets.getPrioriter());
                    p.setCategorie(tickets.getCategorie());
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

    @Override
    public List<Tickets> searchTickets(Categorie query) {
        return ticketRepository.findByCategorie(query);
    }

    @Override
    public Tickets prendreEnCharge(Long id) {
        return ticketRepository.findById(id)
                .map(p -> {
                    if (p.getEtat().getLibelle().equals("en cours") || p.getEtat().getLibelle().equals("resolu")) {
                        throw new RuntimeException("Ce ticket est déjà pris en charge ou résolu.");
                    }

                    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                    Utilisateur formateur = utilisateurRepository.findByEmail(authentication.getName())
                            .orElseThrow(() -> new RuntimeException("Formateur non trouvé : " + authentication.getName()));
                    p.setFormateur(formateur);
                    Etat etatEnCours = etatService.getEtatEncours();
                    p.setEtat(etatEnCours);
                    Tickets updatedTicket = ticketRepository.save(p);

                    String sujet = "Ticket pris en charge";
                    String corps = "Votre ticket N°" + p.getId() + " a été pris en charge par " + formateur.getNom()+ ".";
                    emailService.sendSimpleMessage(p.getApprenant().getEmail(), sujet, corps);

                    return updatedTicket;
                }).orElseThrow(() -> new RuntimeException("Ticket non trouvé"));
    }

    @Override
    public Tickets resoudre(Long id, String reponseContenu) {
        return ticketRepository.findById(id)
                .map(p -> {
                    Etat etatResolu = etatService.getEtatResolu();
                    if (p.getEtat().equals(etatResolu)) {
                        throw new RuntimeException("Le ticket a déjà été résolu.");
                    }

                    if (!p.getEtat().getLibelle().equals("en cours")) {
                        throw new RuntimeException("Le ticket doit être pris en charge avant d'être résolu.");
                    }

                    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                    Utilisateur formateur = utilisateurRepository.findByEmail(authentication.getName())
                            .orElseThrow(() -> new RuntimeException("Formateur non trouvé : " + authentication.getName()));

                    Reponse reponse = new Reponse();
                    reponse.setReponse(reponseContenu);
                    reponse.setDateEnvoie(new Date());
                    reponse.setTickets(p);
                    reponse.setIdFormateur(formateur);

                    reponseRepository.save(reponse);

                    p.setReponseFormateur(reponse);
                    p.setDateResolution(new Date());
                    p.setEtat(etatResolu);

                    ticketRepository.save(p);

                    String sujet = "Ticket résolu";
                    String corps = "Le ticket " + p.getId() + " a été résolu par " + formateur.getNom() + ".";
                    emailService.sendSimpleMessage(p.getApprenant().getEmail(), sujet, corps);

                    return p;
                }).orElseThrow(() -> new RuntimeException("Ticket non trouvé"));
    }

    public String SendSimpleMail(String to, String cc, String subject, String text) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(to);
            mailMessage.setCc(cc);
            mailMessage.setSubject(subject);
            mailMessage.setText(text);

            javaMailSender.send(mailMessage);

            return "Mail envoyé";

        } catch (Exception e) {
            e.printStackTrace(); // Affiche les détails de l'exception dans les logs
            throw new RuntimeException(e);
        }
    }

}
