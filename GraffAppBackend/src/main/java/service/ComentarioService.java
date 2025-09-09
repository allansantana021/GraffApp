package service;

import entity.Comentario;
import org.springframework.stereotype.Service;
import repository.ComentarioRepository;

import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public List<Comentario> listarComentarios() {
        return comentarioRepository.findAll();
    }

    public Comentario buscarPorId(Integer id) {
        return comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentário não encontrado com id: " + id));
    }

    public Comentario criarComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public Comentario atualizarComentario(Integer id, Comentario comentarioAtualizado) {
        Comentario comentarioExistente = buscarPorId(id);
        comentarioExistente.setTexto(comentarioAtualizado.getTexto());
        comentarioExistente.setComentario_data_publicacao(comentarioAtualizado.getComentario_data_publicacao());
        comentarioExistente.setUsuario(comentarioAtualizado.getUsuario());
        return comentarioRepository.save(comentarioExistente);
    }

    public void deletarComentario(Integer id) {
        Comentario comentarioExistente = buscarPorId(id);
        comentarioRepository.delete(comentarioExistente);
    }
}