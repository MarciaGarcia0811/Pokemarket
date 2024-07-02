package com.generation.pokemarket2.controller;

import com.generation.pokemarket2.models.Pedido;
import com.generation.pokemarket2.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;
    @GetMapping("/lista")
    public List<Pedido> findAllPedido(){
        return pedidoService.findAllPedido();
    }

}
