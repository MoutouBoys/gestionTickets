package com.ticket.gestionTicket.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PRIORITER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Prioriter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String libelle;
    private String description;
}
