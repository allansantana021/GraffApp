package service;

import entity.Curtida;
import org.springframework.stereotype.Service;
import repository.CurtidaRepository;

import java.util.List;

@Service
public class CurtidaService {

    private CurtidaRepository curtidaRepository;

    public CurtidaService(CurtidaRepository curtidaRepository ) {this.curtidaRepository = curtidaRepository;}

    public List<Curtida> listarCurtidas() {return this.curtidaRepository.findAll();}
 }
