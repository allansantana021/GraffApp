package controller;

import entity.Comentario;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ComentarioService;

import java.util.List;

@RestController
@RequestMapping("api/comentario")
public class ComentarioController {

    private ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService){
        this.comentarioService = comentarioService;

    }
    @GetMapping("/listar")
    public ResponseEntity<List<Comentario>> listarComentarios(){
        return ResponseEntity.ok(comentarioService.listarComentarios());
    }
}
