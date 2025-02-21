package org.example.deliveryservicebotpro.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.deliveryservicebotpro.entity.User;
import org.example.deliveryservicebotpro.repos.UserRepository;
import org.example.deliveryservicebotpro.service.JwtService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class MyFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserRepository userRepository;

    public MyFilter(JwtService jwtService, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if (token != null) {
            token = token.substring(7);
            if (jwtService.validate(token)) {
                String email = jwtService.getUsername(token);
                User user = userRepository.findByEmail(email);
                var auth= new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        null,
                        user.getRoles()
                );
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(request, response);
    }
}
