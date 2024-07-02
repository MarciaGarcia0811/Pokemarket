package com.generation.pokemarket2.controller;

import com.generation.pokemarket2.models.Productos;
import com.generation.pokemarket2.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/producto")
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @GetMapping("/{id}")
    public Productos getProductoPorId(@PathVariable Long id) {
        var productoSolicitado = productosService.findById(id);
        return productoSolicitado;
    }
    @GetMapping("/{id}/precio")
    public Object precioProducto (@PathVariable Long id) {
        var precioProducto = productosService.findById(id).getPrecio();
        return precioProducto;
    }

    @PostMapping("/new")
    public Productos addProducto(@RequestBody Productos producto){ //RequestBody indica que se entregara un objeto en el cuerpo de la peticion
        Productos productoAgregado = productosService.agregarProducto(producto);
                return productoAgregado;
    }
    //Para indicar la interaccion de borrado creado en el service
    @DeleteMapping("/delete")
    //Response Entity, nos permite modificar el cuerpo de la respuesta, el estatus de respuesta, para que nos devuelva una frase como "El producto se borro exitosamente"
    public ResponseEntity<String> eliminarProducto(@RequestParam Long id){
        productosService.eliminarProducto(id);
        return new ResponseEntity<> ("Eliminado exitosamente", HttpStatus.OK);
    }


}
