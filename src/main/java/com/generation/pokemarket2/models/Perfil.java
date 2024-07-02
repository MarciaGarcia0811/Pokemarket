package com.generation.pokemarket2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "perfiles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fotoPerfil;

    //Relacion 1:1 se crea mediante la anotacion OneToOne
    @OneToOne
    //JoinColumn indica cual es la llave foranea en la tabla actual
    @JoinColumn(name = "usuario_id") //le indico como quiero que se llame la columna en la nueva tabla
   //Creo un campo o atributo usando la otra entidad como tipo de dato
    private Usuario usuarioId;






}
