package controller;

import entity.Curtida;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CurtidaService;

import java.util.List;

@RestController
@RequestMapping("api/curtida")
public class CurtidaController {

    private CurtidaService curtidaService;

    public CurtidaController(CurtidaService curtidaService){
        this.curtidaService = curtidaService;
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Curtida>> listarCurtidas(){
        return ResponseEntity.ok(curtidaService.listarCurtidas());
    }
}
