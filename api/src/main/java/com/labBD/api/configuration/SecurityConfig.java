package com.labBD.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http){
        try {
            http.csrf().disable().authorizeRequests().anyRequest().permitAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            return http.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}