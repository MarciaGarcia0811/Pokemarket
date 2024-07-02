package com.generation.pokemarket2.controller;
import com.generation.pokemarket2.dto.UsuarioDTO;
import com.generation.pokemarket2.models.Usuario;
import com.generation.pokemarket2.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

//El controller presenta la vista al usuario
@RestController
@RequestMapping
public class UsuarioController {
    private UsuarioService usuarioService;

    //Metodo a ejecutarse al momento de ingresar a la ruta
    @GetMapping("/")
    public String getUsuarioById(){
        Usuario usuarioSolicitado = usuarioService.findById(1L);
        return "Hola soy " + usuarioSolicitado.getNombre();
    }
    @GetMapping("/{nombre}")
    public String getUsuarioByNombre(@PathVariable String nombre){
        Usuario usuarioSolicitado = usuarioService.obtenerUsuarioPorNombre(nombre);
            return "Hola soy "
                    + usuarioSolicitado.getNombre()
                    + " "
                    + usuarioSolicitado.getApellido();
    }
    @PostMapping("/nuevo")
    public ResponseEntity<?> guardarUsuario(@RequestBody @Valid UsuarioDTO nuevoUsuario, BindingResult result){
       if (result.hasErrors()){
           return new ResponseEntity<>("Verifique los campos", HttpStatus.NOT_ACCEPTABLE);
       }

        //Usuario usuarioGuardado = usuarioService.guardarNuevoUsuario(nuevoUsuario);

        return new ResponseEntity<>(usuarioService.guardarNuevoUsuario(nuevoUsuario), HttpStatus.CREATED);
    }

    @PutMapping("/editar/{correo}")
    public ResponseEntity<?> editarUsuarioPorCorreo(@PathVariable String correo,
                                                    @RequestBody @Valid UsuarioDTO usuarioParaEditar,
                                                    BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Verifica los campos antes de editar", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(usuarioService.editarUsuarioPorCorreo(usuarioParaEditar, correo),
                HttpStatus.OK);
    }
    @GetMapping("/buscar")
    public ResponseEntity<?> buscarPorApellidoNombre(@RequestParam String apellido,
                                                     @RequestParam String nombre) {
        return new ResponseEntity<>(usuarioService.
                buscarUsuarioPorApellidoNombre(apellido, nombre),
                HttpStatus.OK);
    }
}
