package controller;

import entity.Grafite;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.GrafiteService;

import java.util.List;

@RestController
@RequestMapping("api/grafite")
public class GrafiteController {

    private GrafiteService grafiteService;

    public GrafiteController(GrafiteService grafiteService){
        this.grafiteService = grafiteService; }
    @GetMapping("/listar")
    public ResponseEntity<List<Grafite>> listarGrafites(){
        return ResponseEntity.ok(grafiteService.listarGrafites());

    }

}




