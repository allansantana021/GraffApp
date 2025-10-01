package com.GraffAppBackend.GraffAppBackend.repository;

import com.GraffAppBackend.GraffAppBackend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional; // Importação necessária para Optional

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
}