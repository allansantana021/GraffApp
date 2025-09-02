package service;

import entity.Comentario;
import org.springframework.stereotype.Service;
import repository.ComentarioRepository;

import java.util.List;

@Service
public class ComentarioService {
    private ComentarioRepository comentarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository) { this.comentarioRepository = comentarioRepository;}

    public List<Comentario> listarComentarios() { return this.comentarioRepository.findAll();}
}
