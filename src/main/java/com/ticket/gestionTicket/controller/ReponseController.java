package com.ticket.gestionTicket.controller;

import com.ticket.gestionTicket.modele.Reponse;
import com.ticket.gestionTicket.service.service.ReponseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reponse")
@AllArgsConstructor
public class ReponseController {
    private final ReponseService reponseService;

    @PostMapping("/create")
    public Reponse creerReponse(@RequestBody Reponse reponse) {
        return reponseService.creerReponse(reponse);
    }

    @GetMapping("/read")
    public List<Reponse> read(){
        return reponseService.list();
    }

    @PutMapping("/update/{id}")
    public Reponse update(@PathVariable Long id, @RequestBody Reponse reponse){
        return reponseService.modifier(id, reponse);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return reponseService.supprimer(id);
    }
}
