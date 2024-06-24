package com.ticket.gestionTicket.service.serviceImp;

import com.ticket.gestionTicket.modele.Utilisateur;
import com.ticket.gestionTicket.repository.UtilisateurRepository;
import com.ticket.gestionTicket.service.service.UtilisateurService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UtilisateurRepository userRepository;

    /*@PostConstruct
    public void encodePasswords() {
        List<Utilisateur> users = userRepository.findAll();
        for (Utilisateur user : users) {
            if (!user.getMotDePasse().startsWith("{bcrypt}")) {  // Vérifiez si le mot de passe est déjà encodé
                String encodedPassword = passwordEncoder.encode(user.getMotDePasse());
                user.setMotDePasse(encodedPassword);
                userRepository.save(user);
            }
        }
        }*/
    @Autowired
    public UtilisateurServiceImpl(@Lazy UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
    @Override
    public Utilisateur creer(Utilisateur user) {
        return utilisateurRepository.save(user);
    }

    @Override
    public List<Utilisateur> lire() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur modifier(Long id, Utilisateur user) {
        return utilisateurRepository.findById(id)
                .map(p -> {
                    p.setNom(user.getNom());
                    p.setEmail(user.getEmail());
                    p.setMotDePasse(user.getMotDePasse());
                    p.setRole(user.getRole());
                    return utilisateurRepository.save(p);
                }).orElseThrow(()->new RuntimeException("Utilisateur n'existe pas!"));
    }

    @Override
    public String supprimer(Long id) {
        utilisateurRepository.deleteById(id);
        return "Utilisateur supprimer";
    }
}
