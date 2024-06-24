package com.ticket.gestionTicket.controller;

import com.ticket.gestionTicket.modele.Formateur;
import com.ticket.gestionTicket.service.service.FormateurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formateur")
@AllArgsConstructor
public class FormateurController {
    private final FormateurService formateurService;

    @PostMapping("/create")
    public Formateur create(@RequestBody Formateur formateur){
        return formateurService.creer(formateur);
    }
    @GetMapping("/read")
    public List<Formateur> read(){
        return formateurService.lire();
    }
    @PutMapping("/update/{id}")
    public Formateur update(@PathVariable Long id, @RequestBody Formateur formateur){
        return formateurService.modifier(id, formateur);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return formateurService.supprimer(id);
    }
}
