package com.generation.pokemarket2.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder //Nos da otra sintaxis para la construccion del objeto
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private String apellido;

    private String correo;

    private String password;

    //Creamos la relacion OneToOne desde el perfil pero tambien debemos crearlo aqui
    //Debo indicar desde donde viene mapeado (mappedBy)
    //El mappedBy debe llevar el mismo nombre de la variable de Usuario
    @OneToOne(mappedBy = "usuarioId")
    private Perfil perfilUsuario;

    //Relacion con metodos de pago, pero uno es a muchos tipos de metodos de pagos
    @OneToMany(mappedBy = "usuario")
    //Es una lista de sus metodos de pago asociados que se va a llamar metodosdepagousuarios
    private List<MetodoPago> metodoPagoUsuario;

    @OneToMany(mappedBy = "usuarioPedido")
    private List<Pedido> pedidosUsuario;

    @CreationTimestamp
    @Column(name = "fecha_registro")
    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rolUsuario;

}
