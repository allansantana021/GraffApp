package controller;

import entity.Usuario;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService; }
        @GetMapping("/listar")
                public ResponseEntity<List<Usuario>> listarUsuarios(){
            return ResponseEntity.ok(usuarioService.listarUsuarios());
        }
    }

