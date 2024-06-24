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
    private String ticketEnvoyer;
    private String status;
    private Long idUtilisateur;
    private Date dateEnvoie;
}
