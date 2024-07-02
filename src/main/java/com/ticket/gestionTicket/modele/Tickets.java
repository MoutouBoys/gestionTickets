package com.ticket.gestionTicket.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.ticket.gestionTicket.modele.Utilisateur;

import java.util.Date;

@Entity
@Table(name = "TICKETS")
@Getter
@Setter
@NoArgsConstructor
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    private String description;
    private Date dateEnvoie;
    private Date dateResolution;

    @ManyToOne
    private Etat etat;

    @ManyToOne
    private Categorie categorie;

    @ManyToOne
    private Utilisateur formateur;

    @ManyToOne
    private Utilisateur apprenant;

    @ManyToOne
    private Prioriter prioriter;

    @ManyToOne(cascade = CascadeType.ALL)
    private Reponse reponseFormateur;

}
