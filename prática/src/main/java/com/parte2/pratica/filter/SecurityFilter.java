package com.parte2.pratica.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;

@Controller //Marca a classe como um controller do Spring
@EnableWebSecurity //Ativa as configurações de segurança
public class SecurityFilter {

    @Bean //Informa ao Spring que o metodo retorna um objeto que deve ser gerenciado pelo container
    public SecurityFilterChain securityFilterChain(HttpSecurity htpp){
        return htpp.csrf( csrf -> csrf.disable())
                .sessionManagement( session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.GET, "/produtos").permitAll())
                .authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.POST,"/produtos").permitAll())
                .build();
    }
}
