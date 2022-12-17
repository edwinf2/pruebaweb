package com.pruebaweb.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author Edwin
 */
@Entity
@Data
@Table(name = "rol")
public class Rol implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private Long idRol;
    
    @NotEmpty
    @Column(name = "nombre")
    private String nombre;
    
}
