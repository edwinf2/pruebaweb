
package com.pruebaweb.domain;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author Edwin
 */

//Entidad OpcionesMenu

@Data
@Entity
@Table(name = "opciones_menu")
public class OpcionesMenu implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idopc")
    private Long idOpciones;

    @Column(name = "etiqueta")
    private String etiqueta;

    @Column(name = "comando")
    private String comando;
    
    @Column(name = "estado")
    private String estado;
//    
//    @OneToMany()
//    @JoinColumn(name = "idopc")
//    private List<AccesosUsuario> accesosUsuario;
    
    @ManyToMany()
    private List<Usuarios> usuarios;
    
}
