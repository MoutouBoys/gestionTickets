package com.ticket.gestionTicket.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "APPRENANT")
@Getter
@Setter
@NoArgsConstructor
public class Apprenant extends Utilisateur {
    private Long niveau;
    private String progres;
    private Long ticketsSoumis;
}
