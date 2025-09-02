package service;

import entity.Grafite;
import org.springframework.stereotype.Service;
import repository.GrafiteRepository;

import java.util.List;

@Service
public class GrafiteService {

    private GrafiteRepository grafiteRepository;

    public GrafiteService(GrafiteRepository grafiteRepository) { this.grafiteRepository = grafiteRepository;}

    public List<Grafite> listarGrafites() { return this.grafiteRepository.findAll();}
}
