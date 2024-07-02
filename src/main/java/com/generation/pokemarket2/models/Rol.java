package com.generation.pokemarket2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    //Mapea un tipo enumerado (enum) a una columna de la base de datos para la tabla Rol
    @Enumerated(EnumType.STRING) //ya que la columna que vamos a crear se refiere a valores string (palabras)
    @Column(name = "nombre_rol")
    private ERol nombreRol;
}
