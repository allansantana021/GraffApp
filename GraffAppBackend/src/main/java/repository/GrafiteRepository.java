package repository;

import entity.Grafite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrafiteRepository extends JpaRepository<Grafite, Integer> {
}
