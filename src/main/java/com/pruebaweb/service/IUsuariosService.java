package com.pruebaweb.service;

import com.pruebaweb.domain.Usuarios;
import java.util.*;

/**
 *
 * @author Edwin
 */
public interface IUsuariosService {
    
    public List<Usuarios> listarUsuarios();
    
    public void guardar(Usuarios usuario);
    
    public void eliminar(Usuarios usuario);
    
    public Usuarios encontrarUsuario(Usuarios usuario);
    
}
