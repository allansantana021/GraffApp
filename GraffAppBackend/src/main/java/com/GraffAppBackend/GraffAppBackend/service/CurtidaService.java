package com.GraffAppBackend.GraffAppBackend.service;

import com.GraffAppBackend.GraffAppBackend.entity.Curtida;
import com.GraffAppBackend.GraffAppBackend.repository.CurtidaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurtidaService {

    private final CurtidaRepository curtidaRepository;

    public CurtidaService(CurtidaRepository curtidaRepository) {
        this.curtidaRepository = curtidaRepository;
    }

    public List<Curtida> listarCurtidas() {
        return curtidaRepository.findAll();
    }

    public Curtida buscarPorId(Integer id) {
        return curtidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curtida não encontrada com id: " + id));
    }


    public Curtida criarCurtida(Curtida curtida) {
        return curtidaRepository.save(curtida);
    }

    public Curtida atualizarCurtida(Integer id, Curtida curtidaAtualizada) {
        Curtida curtidaExistente = buscarPorId(id);
        curtidaExistente.setData(curtidaAtualizada.getData());
        curtidaExistente.setUsuario(curtidaAtualizada.getUsuario());
        curtidaExistente.setGrafite(curtidaAtualizada.getGrafite());
        return curtidaRepository.save(curtidaExistente);
    }

    public void deletarCurtida(Integer id) {
        Curtida curtidaExistente = buscarPorId(id);
        curtidaRepository.delete(curtidaExistente);
    }
}