package com.GraffAppBackend.GraffAppBackend.controller;

import com.GraffAppBackend.GraffAppBackend.dto.request.UsuarioDTORequest;
import com.GraffAppBackend.GraffAppBackend.dto.response.UsuarioDTOResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.GraffAppBackend.GraffAppBackend.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTOResponse>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/buscarUsuarioPorId/{id}")
    public ResponseEntity<UsuarioDTOResponse> buscarUsuarioPorId(@PathVariable int id) {
        UsuarioDTOResponse usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/criarUsuario")
    public ResponseEntity<UsuarioDTOResponse> criarUsuario(@RequestBody UsuarioDTORequest usuarioDto) {
        UsuarioDTOResponse novoUsuario = usuarioService.criarUsuario(usuarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @PutMapping("/atualizarUsuario/{id}")
    public ResponseEntity<UsuarioDTOResponse> atualizarUsuario(
            @PathVariable int id,
            @RequestBody UsuarioDTORequest usuarioAtualizadoDto
    ) {
        UsuarioDTOResponse usuario = usuarioService.atualizarUsuario(id, usuarioAtualizadoDto);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/deletarUsuario/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable int id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}