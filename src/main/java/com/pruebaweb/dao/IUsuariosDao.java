package com.pruebaweb.dao;

import com.pruebaweb.domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Edwin
 */
public interface IUsuariosDao extends JpaRepository<Usuarios, Long>{
    Usuarios findByUsername(String username);    
}
