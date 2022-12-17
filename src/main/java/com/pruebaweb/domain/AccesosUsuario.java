package com.pruebaweb.domain;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author Edwin
 */

@Data
@Entity
@Table(name = "accesos_usuario")
public class AccesosUsuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idacc")
    private Long idAccesosUsuario;
    
//    @OneToMany()
//    @JoinColumn(name = "idusr")
//    private List<Usuarios> usuarios;
//    
//    @OneToMany()
//    @JoinColumn(name = "idacc")
//    private List<OpcionesMenu> opcionesMenu;
    
}
