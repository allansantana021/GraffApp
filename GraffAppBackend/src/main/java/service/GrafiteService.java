package service;

import entity.Grafite;
import org.springframework.stereotype.Service;
import repository.GrafiteRepository;

import java.util.List;

@Service
public class GrafiteService {

    private final GrafiteRepository grafiteRepository;

    public GrafiteService(GrafiteRepository grafiteRepository) {
        this.grafiteRepository = grafiteRepository;
    }

    public List<Grafite> listarGrafites() {
        return grafiteRepository.findAll();
    }

    public Grafite buscarPorId(int id) {
        return grafiteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grafite não encontrado com id: " + id));
    }

    public Grafite criarGrafite(Grafite grafite) {
        return grafiteRepository.save(grafite);
    }

    public Grafite atualizarGrafite(int id, Grafite grafiteAtualizado) {
        Grafite grafiteExistente = buscarPorId(id);
        grafiteExistente.setTitulo(grafiteAtualizado.getTitulo());
        // Atualize outros campos se existirem
        return grafiteRepository.save(grafiteExistente);
    }

    public void deletarGrafite(int id) {
        Grafite grafiteExistente = buscarPorId(id);
        grafiteRepository.delete(grafiteExistente);
    }
}
