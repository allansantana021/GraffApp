package controller;

import entity.Curtida;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CurtidaService;

import java.util.List;

@RestController
@RequestMapping("api/curtida")
public class CurtidaController {

    private final CurtidaService curtidaService;

    public CurtidaController(CurtidaService curtidaService){
        this.curtidaService = curtidaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Curtida>> listarCurtidas(){
        return ResponseEntity.ok(curtidaService.listarCurtidas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curtida> buscarCurtidaPorId(@PathVariable Integer id) {
        Curtida curtida = curtidaService.buscarPorId(id);
        return ResponseEntity.ok(curtida);
    }

    @PostMapping
    public ResponseEntity<Curtida> criarCurtida(@RequestBody Curtida curtida) {
        Curtida novaCurtida = curtidaService.criarCurtida(curtida);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCurtida);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curtida> atualizarCurtida(@PathVariable Integer id, @RequestBody Curtida curtidaAtualizada) {
        Curtida curtida = curtidaService.atualizarCurtida(id, curtidaAtualizada);
        return ResponseEntity.ok(curtida);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCurtida(@PathVariable Integer id) {
        curtidaService.deletarCurtida(id);
        return ResponseEntity.noContent().build();
    }
}