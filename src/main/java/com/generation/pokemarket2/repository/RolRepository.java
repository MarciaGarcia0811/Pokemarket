package com.generation.pokemarket2.repository;

import com.generation.pokemarket2.models.ERol;
import com.generation.pokemarket2.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Rol findRolByNombreRol(ERol nombreRol);
}
