package com.ticket.gestionTicket.repository;

import com.ticket.gestionTicket.modele.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
