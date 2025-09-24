package com.GraffAppBackend.GraffAppBackend.controller;

import com.GraffAppBackend.GraffAppBackend.entity.Comentario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.GraffAppBackend.GraffAppBackend.service.ComentarioService;

import java.util.List;

@RestController
@RequestMapping("api/comentario")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService){
        this.comentarioService = comentarioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Comentario>> listarComentarios(){
        return ResponseEntity.ok(comentarioService.listarComentarios());
    }

    @GetMapping("/buscarComentarioPorId")
    public ResponseEntity<Comentario> buscarComentarioPorId(@PathVariable Integer id) {
        Comentario comentario = comentarioService.buscarPorId(id);
        return ResponseEntity.ok(comentario);
    }

    @PostMapping("/criarComentario")
    public ResponseEntity<Comentario> criarComentario(@RequestBody Comentario comentario) {
        Comentario novoComentario = comentarioService.criarComentario(comentario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoComentario);
    }

    @PutMapping("/atualizarComentario")
    public ResponseEntity<Comentario> atualizarComentario(@PathVariable Integer id, @RequestBody Comentario comentarioAtualizado) {
        Comentario comentario = comentarioService.atualizarComentario(id, comentarioAtualizado);
        return ResponseEntity.ok(comentario);
    }

    @DeleteMapping("/deletarComentario")
    public ResponseEntity<Void> deletarComentario(@PathVariable Integer id) {
        comentarioService.deletarComentario(id);
        return ResponseEntity.noContent().build();
    }
}