package com.GraffAppBackend.GraffAppBackend.controller;

import com.GraffAppBackend.GraffAppBackend.entity.Grafite;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.GraffAppBackend.GraffAppBackend.service.GrafiteService;

import java.util.List;

@RestController
@RequestMapping("api/grafite")
public class GrafiteController {

    private final GrafiteService grafiteService;

    public GrafiteController(GrafiteService grafiteService){
        this.grafiteService = grafiteService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Grafite>> listarGrafites(){
        return ResponseEntity.ok(grafiteService.listarGrafites());
    }

    @GetMapping("/buscarGrafitePorId")
    public ResponseEntity<Grafite> buscarGrafitePorId(@PathVariable int id) {
        Grafite grafite = grafiteService.buscarPorId(id);
        return ResponseEntity.ok(grafite);
    }

    @PostMapping("/criarGrafite")
    public ResponseEntity<Grafite> criarGrafite(@RequestBody Grafite grafite) {
        Grafite novoGrafite = grafiteService.criarGrafite(grafite);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoGrafite);
    }

    @PutMapping("/atualizarGrafite")
    public ResponseEntity<Grafite> atualizarGrafite(@PathVariable int id, @RequestBody Grafite grafiteAtualizado) {
        Grafite grafite = grafiteService.atualizarGrafite(id, grafiteAtualizado);
        return ResponseEntity.ok(grafite);
    }

    @DeleteMapping("/deletarGrafite")
    public ResponseEntity<Void> deletarGrafite(@PathVariable int id) {
        grafiteService.deletarGrafite(id);
        return ResponseEntity.noContent().build();
    }
}
