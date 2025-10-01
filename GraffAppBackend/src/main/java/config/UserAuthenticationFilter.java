package config;

import com.GraffAppBackend.GraffAppBackend.entity.Usuario;
import com.GraffAppBackend.GraffAppBackend.repository.UsuarioRepository;
import com.GraffAppBackend.GraffAppBackend.service.UserDetailsImpl; // Importação corrigida
import com.GraffAppBackend.GraffAppBackend.service.JwtTokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

@Component
public class UserAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenService jwtTokenService; // Service que definimos anteriormente

    @Autowired
    private UsuarioRepository usuarioRepository; // Repository que definimos anteriormente

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Verifica se o endpoint requer autenticação antes de processar a requisição
        if (checkIfEndpointIsNotPublic(request)) {
            String token = recoveryToken(request); // Recupera o token do cabeçalho Authorization da requisição
            if (token != null) {
                String subject = jwtTokenService.getSubjectFromToken(token); // Obtém o assunto (neste caso, o nome de usuário/email) do token

                // CORRIGIDO: Chamada ao método de instância do repositório 'usuarioRepository'
                // Assumindo que você tem um método 'findByEmail' no seu UsuarioRepository.
                Usuario usuario = usuarioRepository.findByEmail(subject)
                        .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o email: " + subject));

                // CORRIGIDO: Cria um UserDetails com o objeto 'usuario' encontrado
                UserDetailsImpl userDetails = new UserDetailsImpl(usuario);

                // Cria um objeto de autenticação do Spring Security
                Authentication authentication =
                        new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());

                // Define o objeto de autenticação no contexto de segurança do Spring Security
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                // Esta exceção será capturada e deve ser tratada por um SecurityExceptionHandler
                throw new RuntimeException("O token está ausente.");
            }
        }
        filterChain.doFilter(request, response); // Continua o processamento da requisição
    }

    // Recupera o token do cabeçalho Authorization da requisição
    private String recoveryToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            // CORRIGIDO: Uso do método startsWith para garantir que o prefixo exista
            return authorizationHeader.replace("Bearer ", "");
        }
        return null;
    }

    // Verifica se o endpoint requer autenticação antes de processar a requisição
    private boolean checkIfEndpointIsNotPublic(HttpServletRequest request) {
        //ajustado para funcionamento do swagger
        String requestURI = request.getRequestURI();
        // NOTA: É necessário que você tenha a classe SecurityConfiguration e o array ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED definidos.
        return Arrays.stream(SecurityConfiguration.ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED).noneMatch(publicEndpoint ->
                requestURI.startsWith(publicEndpoint.replace("/**", "")) // suporta wildcard
        );
    }
}