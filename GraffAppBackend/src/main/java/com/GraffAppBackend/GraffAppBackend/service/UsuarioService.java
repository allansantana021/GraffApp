package com.GraffAppBackend.GraffAppBackend.service;

import com.GraffAppBackend.GraffAppBackend.repository.UsuarioRepository;
import com.GraffAppBackend.GraffAppBackend.entity.Usuario;
import com.GraffAppBackend.GraffAppBackend.dto.request.UsuarioDTORequest; // DTO Request
import com.GraffAppBackend.GraffAppBackend.dto.response.UsuarioDTOResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    

    public List<UsuarioDTOResponse> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioDTOResponse.class))
                .collect(Collectors.toList());
    }

    public UsuarioDTOResponse buscarPorId(int id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + id));
        return modelMapper.map(usuario, UsuarioDTOResponse.class);
    }

    public UsuarioDTOResponse criarUsuario(UsuarioDTORequest usuarioDto) {
        Usuario usuarioEntity = modelMapper.map(usuarioDto, Usuario.class);

        Usuario savedEntity = usuarioRepository.save(usuarioEntity);

        return modelMapper.map(savedEntity, UsuarioDTOResponse.class);
    }

    public UsuarioDTOResponse atualizarUsuario(int id, UsuarioDTORequest usuarioDtoAtualizado) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + id));

        modelMapper.map(usuarioDtoAtualizado, usuarioExistente);

        Usuario updatedEntity = usuarioRepository.save(usuarioExistente);

        return modelMapper.map(updatedEntity, UsuarioDTOResponse.class);
    }

    public void deletarUsuario(int id) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + id));
        usuarioRepository.delete(usuarioExistente);
    }
}