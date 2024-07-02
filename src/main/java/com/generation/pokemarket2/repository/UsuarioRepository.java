package com.generation.pokemarket2.repository;

import com.generation.pokemarket2.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
//JpaRepository hereda de PaginaAndSorting y de CrudRepository, interfaces que tienen metodos para hacer

    //Jpa nos proporciona metodos para trabajar cpn los atributos de las entidades
    Usuario findByNombre(String nombre);

    Usuario findByCorreo(String correo);
//Query me permite indicar una consulta JPQL usando las entidades y atributos como referencias
    //Param me permite indicar un parametro a recibirse como un campo dinámico para la query
    @Query("SELECT u FROM Usuario u WHERE u.apellido = :apellidoUsuario AND u.nombre = :nombreUsuario")
    Usuario encontrarPorApellidoNombre(@Param("apellidoUsuario") String apellidoUsuario,
                                       @Param("nombreUsuario") String nombreUsuario);

    List<Usuario> encontrarPorPatronNombre(String patron);
}
