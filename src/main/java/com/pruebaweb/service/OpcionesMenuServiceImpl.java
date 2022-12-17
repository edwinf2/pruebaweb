package com.pruebaweb.service;

import com.pruebaweb.dao.IOpcionesMenuDao;
import com.pruebaweb.domain.OpcionesMenu;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Edwin
 */

@Service
public class OpcionesMenuServiceImpl implements IOpcionesMenuService{

    @Autowired
    private IOpcionesMenuDao opcionesMenuDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<OpcionesMenu> listarOpcionesMenu() {
        return (List<OpcionesMenu>)opcionesMenuDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public OpcionesMenu encontrarOpcionesMenu(OpcionesMenu opcionesMenu) {
        return opcionesMenuDao.findById(opcionesMenu.getIdOpciones()).orElse(null);
    }
    
}
