package controller;

import entity.Comentario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ComentarioService;

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

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> buscarComentarioPorId(@PathVariable Integer id) {
        Comentario comentario = comentarioService.buscarPorId(id);
        return ResponseEntity.ok(comentario);
    }

    @PostMapping
    public ResponseEntity<Comentario> criarComentario(@RequestBody Comentario comentario) {
        Comentario novoComentario = comentarioService.criarComentario(comentario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoComentario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comentario> atualizarComentario(@PathVariable Integer id, @RequestBody Comentario comentarioAtualizado) {
        Comentario comentario = comentarioService.atualizarComentario(id, comentarioAtualizado);
        return ResponseEntity.ok(comentario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarComentario(@PathVariable Integer id) {
        comentarioService.deletarComentario(id);
        return ResponseEntity.noContent().build();
    }
}