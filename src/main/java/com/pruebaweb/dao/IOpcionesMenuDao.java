package com.pruebaweb.dao;

import com.pruebaweb.domain.OpcionesMenu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Edwin
 */


public interface IOpcionesMenuDao extends JpaRepository<OpcionesMenu, Long>{
    OpcionesMenu findByEstado(String estado);
}
