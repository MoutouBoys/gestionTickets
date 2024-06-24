package com.ticket.gestionTicket.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;
import java.util.Map;

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

    //@OneToMany
    private Long niveau;
    private String progres;
    private Long ticketsSoumis;

}
