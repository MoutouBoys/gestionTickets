package com.ticket.gestionTicket.controller;

import com.ticket.gestionTicket.modele.Utilisateur;
import com.ticket.gestionTicket.service.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/utilisateur")
@AllArgsConstructor
public class UtilisateurController {
    private final UtilisateurService utilisateurService;

    @PostMapping("/create")
    public Utilisateur create(@RequestBody Utilisateur user){
        return utilisateurService.creer(user);
    }

    @GetMapping("/read")
    public List<Utilisateur> read(){
        return utilisateurService.lire();
    }

    @PutMapping("/update/{id}")
    public Utilisateur update(@PathVariable Long id, @RequestBody Utilisateur user){
        return utilisateurService.modifier(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return utilisateurService.supprimer(id);
    }
}
