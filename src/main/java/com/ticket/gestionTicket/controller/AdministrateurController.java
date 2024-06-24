package com.ticket.gestionTicket.controller;

import com.ticket.gestionTicket.modele.Administrateur;
import com.ticket.gestionTicket.service.service.AdministrateurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrateur")
@AllArgsConstructor

public class AdministrateurController {
    private final AdministrateurService administrateurService;


    @PostMapping("/create")
    public Administrateur create(@RequestBody Administrateur administrateur){
        return administrateurService.creer(administrateur);
    }

    @GetMapping("/read")
    public List<Administrateur> read(){
        return administrateurService.lire();
    }

    @PutMapping("/update/{id}")
    public Administrateur update(@PathVariable Long id, @RequestBody Administrateur administrateur){
        return administrateurService.modifier(id, administrateur);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return administrateurService.supprimer(id);
    }
}
