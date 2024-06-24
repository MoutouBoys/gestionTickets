package com.ticket.gestionTicket.controller;

import com.ticket.gestionTicket.modele.BaseConnaissance;
import com.ticket.gestionTicket.service.service.BaseConnaissanceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/baseconnaissance")
@AllArgsConstructor
public class BaseConnaissanceController {
    private final BaseConnaissanceService baseConnaissanceService;

    @PostMapping("/create")
    public BaseConnaissance create(@RequestBody BaseConnaissance baseConnaissance) {
        baseConnaissance.setDateEnvoie(new Date());
        return baseConnaissanceService.creer(baseConnaissance);
    }

    @GetMapping("/read")
    public List<BaseConnaissance> read() {
        return baseConnaissanceService.list();
    }

    @PutMapping("/update/{id}")
    public BaseConnaissance update(@PathVariable Long id, @RequestBody BaseConnaissance baseConnaissance) {
        return baseConnaissanceService.modifier(id, baseConnaissance);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return baseConnaissanceService.supprimer(id);
    }
}
