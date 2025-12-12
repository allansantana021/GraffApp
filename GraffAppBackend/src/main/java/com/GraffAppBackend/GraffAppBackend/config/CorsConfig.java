package com.GraffAppBackend.GraffAppBackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // Permite requisições de qualquer origem (para desenvolvimento)
        // Em produção, especifique as origens permitidas: configuration.setAllowedOrigins(Arrays.asList("https://seuapp.com"));
        configuration.setAllowedOriginPatterns(Arrays.asList("*"));

        // Permite todos os métodos HTTP
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));

        // Permite todos os headers
        configuration.setAllowedHeaders(Arrays.asList("*"));

        // Permite credenciais (cookies, authorization headers, etc.)
        configuration.setAllowCredentials(true);

        // Expõe headers de resposta para o cliente
        configuration.setExposedHeaders(Arrays.asList("Authorization", "Content-Type"));

        // Tempo de cache para requisições preflight (OPTIONS)
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
