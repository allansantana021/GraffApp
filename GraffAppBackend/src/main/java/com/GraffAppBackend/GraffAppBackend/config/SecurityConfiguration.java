package com.GraffAppBackend.GraffAppBackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UserAuthenticationFilter userAuthenticationFilter;

    @Autowired
    private CorsConfigurationSource corsConfigurationSource;


    // Adicione esta constante com os endpoints do Swagger
    private static final String[] SWAGGER_ENDPOINTS = {
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
    };

    // Endpoints que não requerem autenticação (usuários novos ou não logados)
    public static final String [] ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED = {
            // As URLs estão aqui apenas para referência, a liberação será feita com HttpMethod
            "/api/usuario/login",
            "/api/usuario/**",
            "/h2-console/**",
    };


    // Endpoints que só podem ser acessados por usuários com permissão de cliente
    public static final String [] ENDPOINTS_USUARIO = {
            // Adicione endpoints específicos de usuário aqui, se houver
    };

    // Endpoints que só podem ser acessados por usuários com permissão de administrador
    public static final String [] ENDPOINTS_ADMIN = {
            "/api/usuario/listar"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource))
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(SWAGGER_ENDPOINTS).permitAll()

                        .requestMatchers(HttpMethod.POST, "/api/usuario/cadastro").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/usuario/login").permitAll()


                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                        // 🔒 REGRAS DE AUTORIZAÇÃO (Verifica se o RoleName no DB é "ADMINISTRADOR" ou "USUARIO")
                        .requestMatchers(ENDPOINTS_ADMIN).hasRole("ADMINISTRADOR")
                        .requestMatchers(ENDPOINTS_USUARIO).hasRole("USUARIO")

                        // 🚫 Qualquer outra requisição deve ser negada
                        .anyRequest().authenticated()
                )
                // 🔑 DESCOMENTE ESTA LINHA se estiver usando o H2 Console
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()))

                .addFilterBefore(userAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
