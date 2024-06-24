package com.ticket.gestionTicket.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "NOTIFICATION")
@Getter
@Setter
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String message;
    private int idUtilisateur;
    private Date dateEvoie;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne
    private Tickets ticket;
    public void marquerCommeVue(){}
}
