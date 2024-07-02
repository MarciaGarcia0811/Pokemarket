package com.generation.pokemarket2.service;

import com.generation.pokemarket2.models.Productos;
import com.generation.pokemarket2.repository.ProductosRepository;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosService {
    @Autowired
    private ProductosRepository productosRepository;
    public Productos findById(Long id) {
        var productos = productosRepository.findById(id);
        return productos.get();
    }

    //Indica que el metodo a crear se debe realizar como una transaccion
    @Transactional
    public Productos agregarProducto(Productos producto){
        return productosRepository.save(producto);
    }

    @Transactional
    //Es void ya que no retornara nada, ya que estamos creando la funcion para eliminar proeductos
    public void eliminarProducto(Long id){
        productosRepository.deleteById(id);
    }


}
