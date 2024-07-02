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

}
