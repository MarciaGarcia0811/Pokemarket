package com.generation.pokemarket2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Timespan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "comentarios")

public class Comentarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String contenido;
    private Integer calificacion;
    @CreationTimestamp //permite registrar la fecha de creacion
    private LocalDateTime fechaCreacion;

    @JsonIgnore
    @ManyToMany
    @JoinColumn(name = "productos_id")
    private Productos productoId;


}

