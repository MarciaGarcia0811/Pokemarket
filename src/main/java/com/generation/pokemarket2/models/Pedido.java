package com.generation.pokemarket2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "pedidos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String metodoPago;
    private Double montoTotal;
    @CreationTimestamp
    private Date fechaVenta;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "metodo_id")
    private MetodoPago metodoPagoPedido;

    private Double montoPedido;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioPedido;

    @JsonIgnore

}
