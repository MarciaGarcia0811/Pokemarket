package com.generation.pokemarket2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categorias")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @ManyToMany()
    @JoinTable(name = "categorias_producto",
    joinColumns = @JoinColumn(name = "categoria_id"),
    inverseJoinColumns = @JoinColumn(name = "categorias_producto"))
    private List<Productos> productosCategoria;
}
