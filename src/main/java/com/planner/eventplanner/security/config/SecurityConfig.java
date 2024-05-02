package com.planner.eventplanner.security.config;

import com.planner.eventplanner.security.DbAuthenticationProvider;
import com.planner.eventplanner.security.variables.StaticVariables;
import jakarta.servlet.FilterChain;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class SecurityConfig {
    private static final String[] PERMIT_ALL = StaticVariables.PERMIT_ALL;
    private static final String[] IGNORE = StaticVariables.IGNORE;

    @Bean
    @SneakyThrows
    public FilterChain securityFilterChain(HttpSecurity http) {

        // TODO: enable csrf
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .requestMatchers(PERMIT_ALL).permitAll()
                        .anyRequest().authenticated())
                .sessionManagement(manager -> manager.sessionCreationPolicy())
                .authenticationProvider(authenticationProvider());
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DbAuthenticationProvider authenticationProvider = new DbAuthenticationProvider();
        authProvider.setUserDetailsService(userService.userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

}
