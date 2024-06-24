package com.ticket.gestionTicket.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ADMINISTRATEUR")
@Getter
@Setter
@NoArgsConstructor
public class Administrateur extends Utilisateur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String gestionDesUtilisateurs;
    private String statistiquesSysteme;
}
