package com.ticket.gestionTicket.controller;

import com.ticket.gestionTicket.modele.Apprenant;
import com.ticket.gestionTicket.service.service.ApprenantService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apprenant")
@AllArgsConstructor
public class ApprenantController {
    private  final ApprenantService apprenantService;

    @PostMapping("/create")
    public Apprenant create(@RequestBody Apprenant apprenant){
        //apprenant.setMotDePasse( PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(apprenant.getMotDePasse()));
        return apprenantService.creer(apprenant);
    }

    @GetMapping("/read")
    public List<Apprenant> read(){
        return apprenantService.lire();
    }

    @PutMapping("/update/{id}")
    public Apprenant update(@PathVariable Long id, @RequestBody Apprenant apprenant){
        return apprenantService.modifier(id,apprenant);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return apprenantService.supprimer(id);
    }
}
