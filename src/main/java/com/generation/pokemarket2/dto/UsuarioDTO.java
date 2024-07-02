package com.generation.pokemarket2.dto;

import com.generation.pokemarket2.models.ERol;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDTO {


    //Anotaciones de validación
    @Pattern(regexp = "^[a-zA-Z]{2,20}$", message = "Campo incorrecto")
    @NotNull(message = "Este campo debe llenarse")
    @Size(min = 2, max = 20)
    private String nombreUsuario;

    @NotBlank
    @Size(min = 2, max = 20, message = "El nombre debe tener entres 2 a 20 caracteres")
    private String apellidoUsuario;

    @Email(message = "Se debe introducir un correo válido")
    private String correoUsuario;

    @NotBlank
    private String password;

    private ERol nombreRol;
}
