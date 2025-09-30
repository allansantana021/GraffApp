package com.GraffAppBackend.GraffAppBackend.repository;

import com.GraffAppBackend.GraffAppBackend.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository <Comentario, Integer> {
}
