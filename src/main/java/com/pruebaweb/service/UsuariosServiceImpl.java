package com.pruebaweb.service;

import com.pruebaweb.dao.IUsuariosDao;
import com.pruebaweb.domain.Usuarios;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Edwin
 */

@Service
public class UsuariosServiceImpl implements IUsuariosService{

    @Autowired
    private IUsuariosDao usuariosDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> listarUsuarios() {
        return (List<Usuarios>)usuariosDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Usuarios usuario) {
        usuariosDao.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(Usuarios usuario) {
        usuariosDao.delete(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios encontrarUsuario(Usuarios usuario) {
        return usuariosDao.findById(usuario.getIdUsuario()).orElse(null);
    }
    
}
