package com.ticket.gestionTicket.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "UTILISATEUR")
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur implements UserDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(length = 50)
        private String nom;

        @Column(unique = true)
        private String email;

        private String motDePasse;

        @ManyToOne
        private Role role;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities(){
                return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + this.role.getLibelle()));
        }

        @Override
        public String getPassword() {
                return this.getMotDePasse();
        }

        @Override
        public String getUsername() {
                return this.getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
                return true;
        }

        @Override
        public boolean isAccountNonLocked() {
                return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return true;
        }

        @Override
        public boolean isEnabled() {
                return true;
        }
}
