package com.ticket.gestionTicket.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Désactiver CSRF pour simplifier les tests avec Postman
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui/**").permitAll() // Permettre l'accès à Swagger UI
                        .requestMatchers("/utilisateur/**").hasAnyRole("ADMIN", "formateur")
                        .requestMatchers("/administrateur/**").hasRole("formateur")
                        //.requestMatchers("mail/send").hasRole("ADMIN")
                        //.requestMatchers("/apprenant/**").hasAnyRole("ADMIN", "formateur") // Accès restreint aux administrateurs et formateurs
                        .requestMatchers("/formateur/**").hasRole("ADMIN")
                        .requestMatchers("/notification/**").hasAnyRole("ADMIN", "formateur") // Accès restreint aux administrateurs et formateurs
                        .requestMatchers("/ticket/**").hasAnyRole("APPRENANT","ADMIN", "formateur")
                        .anyRequest().authenticated() // Toutes les autres requêtes nécessitent une authentification
                )
                .httpBasic(withDefaults()); // Utiliser l'authentification HTTP Basic

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return userDetailsService;
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
