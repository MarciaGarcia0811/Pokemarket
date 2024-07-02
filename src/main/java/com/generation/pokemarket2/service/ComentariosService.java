package com.generation.pokemarket2.service;

import com.generation.pokemarket2.models.Comentarios;
import com.generation.pokemarket2.repository.ComentariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentariosService {
    @Autowired
    private ComentariosRepository comentariosRepository;
    public List<Comentarios> findAllComentarios() {  //<Objeto o clase>
        return comentariosRepository.findAll();
    }
}
