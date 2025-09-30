package com.GraffAppBackend.GraffAppBackend.repository;

import com.GraffAppBackend.GraffAppBackend.entity.Curtida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurtidaRepository extends JpaRepository<Curtida, Integer> {
}
