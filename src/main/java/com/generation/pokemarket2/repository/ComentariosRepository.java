package com.generation.pokemarket2.repository;

import com.generation.pokemarket2.models.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentarios, Long> {
    List<Comentarios> findAllByCalificacion(Integer calificacion);
}
