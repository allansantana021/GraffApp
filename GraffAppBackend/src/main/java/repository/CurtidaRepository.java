package repository;

import entity.Curtida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurtidaRepository extends JpaRepository<Curtida, Integer> {
}
