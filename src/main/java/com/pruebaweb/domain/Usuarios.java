package com.pruebaweb.domain;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author Edwin
 */

//Entidad usuarios de la BBDD

@Data
@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusr")
    private Long idUsuario;
    
    @NotEmpty
    @Column(name = "codigo")
    private String username;
    
    @NotEmpty
    @Column(name = "nombre")
    private String nombre;
    
    @NotEmpty
    @Column(name = "clave")
    private String password;
    
    @OneToMany()
    @JoinColumn(name = "idusr")
    private List<Rol> roles;
//    
//    @OneToMany()
//    @JoinColumn(name = "idusr")
//    private List<AccesosUsuario> accesosUsuario;
    
    @ManyToMany()
    @JoinTable(name = "accesos_usuario",
            joinColumns = @JoinColumn(name = "idusr", nullable = false), 
            inverseJoinColumns = @JoinColumn(name = "idopc", nullable = false) )
    private List<OpcionesMenu> opcionesMenu;
    
}
