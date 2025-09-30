package com.GraffAppBackend.GraffAppBackend.service;

import com.GraffAppBackend.GraffAppBackend.repository.PostRepository;
import com.GraffAppBackend.GraffAppBackend.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> listarPosts() {
        return postRepository.findAll();
    }

    public Post buscarPorId(Integer id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post não encontrado com id: " + id));
    }

    public Post criarPost(Post post) {
        return postRepository.save(post);
    }

    public Post atualizarPost(Integer id, Post postAtualizado) {
        Post postExistente = buscarPorId(id);
        postExistente.setTexto(postAtualizado.getTexto());
        postExistente.setData(postAtualizado.getData());
        postExistente.setTopico(postAtualizado.getTopico());
        postExistente.setStatus(postAtualizado.getStatus());
        postExistente.setUsuario(postAtualizado.getUsuario());
        postExistente.setComentario(postAtualizado.getComentario());
        postExistente.setCurtida(postAtualizado.getCurtida());
        return postRepository.save(postExistente);
    }

    public void deletarPost(Integer id) {
        Post postExistente = buscarPorId(id);
        postRepository.delete(postExistente);
    }
}