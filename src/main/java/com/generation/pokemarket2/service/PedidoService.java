package com.generation.pokemarket2.service;

import com.generation.pokemarket2.models.Pedido;
import com.generation.pokemarket2.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    public List<Pedido> findAllPedido() {  //<Objeto o clase>
        return pedidoRepository.findAll();
    }
}
