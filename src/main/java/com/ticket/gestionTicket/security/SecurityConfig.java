package com.ticket.gestionTicket.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final UserDetailsService customUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/utilisateur/**","/role/**","/prioriter/**","/etat/**","/categorie/**").hasRole("ADMIN");
                    auth.requestMatchers("/baseconnaissance/create","/baseconnaissance/update/","/baseconnaissance/delete/").hasAnyRole("ADMIN","FORMATEUR");
                    auth.requestMatchers("/baseconnaissance/read").authenticated();
                    auth.requestMatchers("/apprenant/**").hasAnyRole("ADMIN","FORMATEUR");
                    auth.requestMatchers("/ticket/create","/ticket/delete/","/ticket/update/").hasRole("APPRENANT");
                    auth.requestMatchers("/categorie/**").hasRole("ADMIN");
                    auth.requestMatchers("/administrateur/**").hasRole("ADMIN");
                    auth.requestMatchers("ticket/search").hasRole("ADMIN");
                    auth.requestMatchers("/utilisateur/users/search/**").hasRole("ADMIN");
                    auth.requestMatchers("/ticket/pris_en_charge/**", "/ticket/resoudre/**").hasRole("FORMATEUR");

                    auth.anyRequest().authenticated();
                })
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf -> csrf.disable())
                .httpBasic(httpBasic -> httpBasic.realmName("AssistantTicket"));

        return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(BCryptPasswordEncoder bCryptPasswordEncoder) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return daoAuthenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
