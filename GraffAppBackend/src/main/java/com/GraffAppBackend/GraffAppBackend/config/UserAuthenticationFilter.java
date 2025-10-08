package com.GraffAppBackend.GraffAppBackend.config;

import com.GraffAppBackend.GraffAppBackend.entity.Usuario;
import com.GraffAppBackend.GraffAppBackend.repository.UsuarioRepository;
import com.GraffAppBackend.GraffAppBackend.service.JwtTokenService;
import com.GraffAppBackend.GraffAppBackend.service.UserDetailsImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class UserAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenService jwtTokenService; // Service que definimos anteriormente

    @Autowired
    private UsuarioRepository usuarioRepository; // Repository que definimos anteriormente

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.replace("Bearer ", "");
            try {
//                String subject = jwtTokenService.getSubjectFromToken(token);
                Integer userId = jwtTokenService.getUserIdFromToken(token);
                Optional<Usuario> maybeUser = usuarioRepository.findById(userId);

                if (maybeUser.isPresent()) {
                    Usuario user = maybeUser.get();
                    UserDetailsImpl userDetails = new UserDetailsImpl(user);

                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (Exception ex) {
                // loga o erro, mas não bloqueia o request aqui
                logger.error("Erro ao validar token: " + ex.getMessage());
            }
        }

        filterChain.doFilter(request, response);
    }
}