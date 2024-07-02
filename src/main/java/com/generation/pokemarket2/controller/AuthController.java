package com.generation.pokemarket2.controller;

import com.generation.pokemarket2.dto.UsuarioDTO;
import com.generation.pokemarket2.service.MyUserDetailsService;
import com.generation.pokemarket2.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO,
                                             BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Los campos son erróneos", HttpStatus.NOT_ACCEPTABLE);
        }
        //Seteamos la contraseña con una encriptada a través del PasswordEncoder
        usuarioDTO.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));
        return new ResponseEntity<>("Usuario registrado exitosamente", HttpStatus.CREATED);
    }
}
