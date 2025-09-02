package service;

import entity.Usuario;
import org.springframework.stereotype.Service;
import repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) { this.usuarioRepository = usuarioRepository;}

    public List<Usuario> listarUsuarios() { return this.usuarioRepository.findAll();}
}
