package com.GraffAppBackend.GraffAppBackend.controller;

import com.GraffAppBackend.GraffAppBackend.entity.Usuario;
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
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/buscarUsuarioPorId")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable int id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/criarUsuario")
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.criarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @PutMapping("/atualizarUsuario")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable int id, @RequestBody Usuario usuarioAtualizado) {
        Usuario usuario = usuarioService.atualizarUsuario(id, usuarioAtualizado);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/deletarUsuario")
    public ResponseEntity<Void> deletarUsuario(@PathVariable int id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}