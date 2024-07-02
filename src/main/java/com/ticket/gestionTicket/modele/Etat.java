package com.ticket.gestionTicket.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ETAT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String libelle;
    private String description;
}
