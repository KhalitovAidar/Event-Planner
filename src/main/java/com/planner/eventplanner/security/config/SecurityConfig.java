package com.planner.eventplanner.security.config;

import com.planner.eventplanner.security.DbAuthenticationProvider;
import com.planner.eventplanner.security.variables.StaticVariables;
import jakarta.servlet.FilterChain;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private static final String[] PERMIT_ALL = StaticVariables.PERMIT_ALL;
    private static final String[] IGNORE = StaticVariables.IGNORE;

    private final DbAuthenticationProvider authenticationProvider;

    @Bean
    @SneakyThrows
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {

        // TODO: enable csrf
        http.authorizeHttpRequests(request -> request
                        .requestMatchers(PERMIT_ALL).permitAll()
                        .anyRequest().authenticated())
             .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
             .authenticationProvider(authenticationProvider);
        return http.build();
    }
}
