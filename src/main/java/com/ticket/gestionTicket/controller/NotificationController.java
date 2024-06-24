package com.ticket.gestionTicket.controller;

import com.ticket.gestionTicket.modele.Notification;
import com.ticket.gestionTicket.service.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/notification")
@AllArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping("/create")
    public Notification create(@RequestBody Notification notification) {
        notification.setDateEvoie(new Date());
        return notificationService.create(notification);
    }

    @PutMapping("/update/{id}")
    public Notification update(@PathVariable Long id, @RequestBody Notification notification) {
        return notificationService.modifier(id,notification);
    }

    @GetMapping("/read")
    public List<Notification> read(){
        return notificationService.lire();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return notificationService.supprimer(id);
    }


}
