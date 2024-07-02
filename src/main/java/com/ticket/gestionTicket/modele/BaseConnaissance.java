package com.ticket.gestionTicket.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "BASECONNAISSANCE")
@Getter
@Setter
@NoArgsConstructor
public class BaseConnaissance{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 300)
    private String question;
    private String reponse;
    private String categorie;
    @ManyToOne
    private Utilisateur idFormateur;
    private Date dateEnvoie;
    @Column(length = 255)
    private String lien;

    @Column(length = 255)
    private String pieceJointe;
}
