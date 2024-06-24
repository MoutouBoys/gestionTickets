package com.ticket.gestionTicket.repository;

import com.ticket.gestionTicket.modele.BaseConnaissance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseConnaissanceRepository extends JpaRepository<BaseConnaissance, Long> {
}
