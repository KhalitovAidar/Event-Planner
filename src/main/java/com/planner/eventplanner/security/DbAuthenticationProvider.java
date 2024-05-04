package com.planner.eventplanner.security;


import com.planner.eventplanner.models.User;
import com.planner.eventplanner.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DbAuthenticationProvider implements AuthenticationProvider {
    private final UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final var password = authentication.getCredentials().toString();
        final var userId = authentication.getPrincipal();

        User user = userRepository.
                findUserById((UUID) userId).orElseThrow(() -> new AuthenticationServiceException("User not found"));

        // TODO: change to real password check
        if (!user.getPassword().equals(password)) {
            throw new AuthenticationServiceException("Invalid username or password");
        }

        return userRepository.findByUsername(authentication.getName())
                .map(userAuth -> new MainAuthentication(userAuth.getId()))
                .orElseThrow(() -> new AuthenticationServiceException("Invalid username or password"));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}