package com.pruebaweb.service;

import com.pruebaweb.domain.OpcionesMenu;
import java.util.*;

/**
 *
 * @author Edwin
 */
public interface IOpcionesMenuService {
     public List<OpcionesMenu> listarOpcionesMenu();
     
     public OpcionesMenu encontrarOpcionesMenu(OpcionesMenu opcionesMenu);
}
