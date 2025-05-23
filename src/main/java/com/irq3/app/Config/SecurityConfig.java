package com.irq3.app.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain (HttpSecurity security) throws Exception{
        return security.authorizeHttpRequests(req -> req.anyRequest()
                        .permitAll()).csrf(AbstractHttpConfigurer::disable).build();
    }
}
