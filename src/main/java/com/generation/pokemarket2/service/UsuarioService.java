package com.generation.pokemarket2.service;

import com.generation.pokemarket2.dto.UsuarioDTO;
import com.generation.pokemarket2.models.Usuario;
import com.generation.pokemarket2.repository.RolRepository;
import com.generation.pokemarket2.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RolRepository rolRepository;

    public Usuario findById(Long id) {
        var usuarios = usuarioRepository.findById(id);
        return usuarios.get();
    }
    public Usuario obtenerUsuarioPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }

//@Transactional
//public Usuario guardarNuevoUsuario(Usuario nuevoUsuario) {
    //    return usuarioRepository.save(nuevoUsuario);}

    @Transactional//logica de negocios, quiere decir que realizara cambios en la base de atos para que la maneje como una transaccion
    public UsuarioDTO guardarNuevoUsuario(UsuarioDTO nuevoUsuario) {
        //Mediante el metodo builder() que funciona como el constructor, construyo la entidad Usuario para guardarlo en la BBDD
        //Obtenemos cada valor para cada campo a traves de los campos con los que viene el DTO
        Usuario usuarioParaGuardar = Usuario.builder()
                .nombre(nuevoUsuario.getNombreUsuario())
                .apellido(nuevoUsuario.getApellidoUsuario())
                .correo(nuevoUsuario.getCorreoUsuario())
                .password(nuevoUsuario.getPassword())
                .build();
        //Seteo el rol consultandolo al repository y tomando en cuenta el rol que viene indicado en el DTO
        usuarioParaGuardar.setRolUsuario(rolRepository.findRolByNombreRol(nuevoUsuario.getNombreRol()));
        //Guardo el nuevo Usuario a traves del repository
           usuarioRepository.save(usuarioParaGuardar);
           return nuevoUsuario;
    }

    @Transactional
    public UsuarioDTO editarUsuarioPorCorreo(UsuarioDTO usuarioEditado, String correo) {
        //Buscamos al usuario a través del correo
        Usuario usuarioActualizar = usuarioRepository.findByCorreo(correo);
        usuarioActualizar.setNombre(usuarioEditado.getNombreUsuario());
        usuarioActualizar.setApellido(usuarioEditado.getApellidoUsuario());
        usuarioActualizar.setCorreo(usuarioEditado.getCorreoUsuario());
        //Para setear al rol, llamamos al metodo repository  buscamos al rol por nombre
        usuarioActualizar.setRolUsuario(rolRepository.findRolByNombreRol(usuarioEditado.getNombreRol()));
        //Finalmente, guardamos los cambios con el metodo save en usuarioRepository
        usuarioRepository.save(usuarioActualizar);
        return usuarioEditado;
        //no se setea la contraseña ya que es un dato vital
    }

    public UsuarioDTO buscarUsuarioPorApellidoNombre(String apellido, String nombre) {
        Usuario usuarioSeleccionado = usuarioRepository.encontrarPorApellidoNombre(apellido, nombre);
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNombreUsuario(usuarioSeleccionado.getNombre());
        usuarioDTO.setApellidoUsuario(usuarioSeleccionado.getApellido());
        return usuarioDTO;
    }

    public List<Usuario> buscarUsuarioPorPatron(String patron) {
        return usuarioRepository.encontrarPorPatronNombre(patron);
    }
}
