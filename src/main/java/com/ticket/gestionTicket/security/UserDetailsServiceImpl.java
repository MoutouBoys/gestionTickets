package com.ticket.gestionTicket.security;

import com.ticket.gestionTicket.modele.Utilisateur;
import com.ticket.gestionTicket.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String nom) throws UsernameNotFoundException {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByNom(nom);
        if (utilisateur.isPresent()) {
            Utilisateur userObjet = utilisateur.get();
            return User.builder()
                    .username(userObjet.getNom())
                    .password(userObjet.getMotDePasse())
                    .roles(userObjet.getRole())
                    .build();
        } else {
            throw new UsernameNotFoundException("Utilisateur non trouvé avec le nom : " + nom);
        }
    }
}
