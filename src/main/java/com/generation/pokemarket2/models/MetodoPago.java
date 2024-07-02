package com.generation.pokemarket2.models;

import jakarta.persistence.*;

import java.util.List;

//Entity indica que va a ser una entidad a representarse en la base de datos
@Entity
//Table me permite cambiar el nombre a la tabla
@Table(name = "metodos_pago")

public class MetodoPago {

    //Id indica que esta columna es la llave primaria
    @Id
    //GenetarionValue indica que estrategia de generacion del valor va adoptar
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrement
    private long id;

    //Column permite cambiar el nombre de la columna y añadirle restriciones
    @Column(name = "metodo")
    private String nombreMetodo;

    //ManyToOne indica que muchos metodos de pago pueden pertenecer a un usuario. Creo la variable usuario en esta tabla
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "metodoPagoPedido")
    private List<MetodoPago> pedidosMetodo;

    //Constructores

    public MetodoPago(long id, String nombreMetodo) {
        this.id = id;
        this.nombreMetodo = nombreMetodo;
    }

    public MetodoPago() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreMetodo() {
        return nombreMetodo;
    }

    public void setNombreMetodo(String nombreMetodo) {
        this.nombreMetodo = nombreMetodo;
    }
}