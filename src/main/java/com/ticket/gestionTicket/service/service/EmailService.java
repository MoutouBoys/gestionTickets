package com.ticket.gestionTicket.service.service;

import org.springframework.web.multipart.MultipartFile;


public interface EmailService {
    String sendMail(MultipartFile[] file, String to,String[] cc, String subject, String body);
}
