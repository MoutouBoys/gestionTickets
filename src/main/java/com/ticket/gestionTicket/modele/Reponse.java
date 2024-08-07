package com.ticket.gestionTicket.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="REPONSE")
@Getter
@Setter
@NoArgsConstructor
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String reponse;
    @ManyToOne
    private Tickets tickets;
    @ManyToOne
    private Utilisateur idFormateur;
    @Column(nullable = false)
    private Date dateEnvoie;
}
