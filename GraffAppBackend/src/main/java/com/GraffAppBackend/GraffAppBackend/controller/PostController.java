package com.GraffAppBackend.GraffAppBackend.controller;

import com.GraffAppBackend.GraffAppBackend.service.PostService;
import com.GraffAppBackend.GraffAppBackend.entity.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Post>> listarPosts(){
        return ResponseEntity.ok(postService.listarPosts());
    }

    @GetMapping("/buscarPostPorId")
    public ResponseEntity<Post> buscarPostPorId(@PathVariable Integer id) {
        Post post = postService.buscarPorId(id);
        return ResponseEntity.ok(post);
    }

    @PostMapping("/criarPost")
    public ResponseEntity<Post> criarPost(@RequestBody Post post) {
        Post novoPost = postService.criarPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPost);
    }

    @PutMapping("/atualizarPost")
    public ResponseEntity<Post> atualizarPost(@PathVariable Integer id, @RequestBody Post postAtualizado) {
        Post post = postService.atualizarPost(id, postAtualizado);
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/deletarPost")
    public ResponseEntity<Void> deletarPost(@PathVariable Integer id) {
        postService.deletarPost(id);
        return ResponseEntity.noContent().build();
    }
}