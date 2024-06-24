package com.ticket.gestionTicket.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "FORMATEUR")
@Getter
@Setter
@NoArgsConstructor
public class Formateur extends Utilisateur {
    private String specialisation;
    private String ticketsAssignes;
    private String evaluations;

    public String classerTicket(Tickets ticket) {
        // Logique pour classer un ticket
        ticket.setStatus("Classé");
        // Vous pouvez ajouter une logique supplémentaire pour gérer le classement
        return "Ticket classé avec succès";
    }

    public String prioriserTicket(Tickets ticket) {
        // Logique pour prioriser un ticket
        ticket.setStatus("Priorisé");
        // Vous pouvez ajouter une logique supplémentaire pour gérer la priorité
        return "Ticket priorisé avec succès";
    }

    public String repondreTicket(Tickets ticket, String reponse) {
        // Logique pour répondre à un ticket
        // Ici, on suppose que vous allez stocker la réponse quelque part, peut-être dans le ticket
        ticket.setStatus("Répondu");
        // Vous pouvez ajouter une logique supplémentaire pour gérer la réponse
        return "Réponse envoyée avec succès";
    }

    public String evaluerApprenant(Apprenant apprenant, Evaluation evaluation) {
        // Logique pour évaluer un apprenant
        // Ajouter l'évaluation à l'apprenant
        evaluation.setApprenant(apprenant);
        // Vous pouvez ajouter une logique supplémentaire pour gérer l'évaluation
        return "Apprenant évalué avec succès";
    }
}
