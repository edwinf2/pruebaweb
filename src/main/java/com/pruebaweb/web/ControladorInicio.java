package com.pruebaweb.web;

import com.pruebaweb.domain.OpcionesMenu;
import com.pruebaweb.domain.Rol;
import com.pruebaweb.domain.Usuarios;
import com.pruebaweb.service.IOpcionesMenuService;
import com.pruebaweb.service.IUsuariosService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Edwin
 */

@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private IUsuariosService usuariosService;
    
    @Autowired
    private IOpcionesMenuService opcionesMenuService;
        
    private String passwordNew;  
    
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
        
        var opciones = opcionesMenuService.listarOpcionesMenu();
        
        log.info("Ejecutando el controlador Spting MVC");
        log.info("Usuario que hizo login" + user);
        model.addAttribute("opciones", opciones);
               
        return "index";
    }
    
    @GetMapping("/opcionesMenu")
    public String listar(Model model){
        
        var usuarios = usuariosService.listarUsuarios();
        
        model.addAttribute("usuarios", usuarios);       
        model.addAttribute("totalUsuarios", usuarios.size());
        
        return "opcionesMenu";    
    }

    @GetMapping("/agregar")
    public String agregar(Usuarios usuario){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Usuarios usuario, Errors errores){
        //Los atributos(Parametros) deben estar juntos
        if(errores.hasErrors()){
            return "modificar";
        }
        
        passwordNew = usuario.getPassword();
        
        usuario.setPassword(encriptarPassword(passwordNew));

        usuariosService.guardar(usuario);
        return "redirect:/opcionesMenu";
    }
    
    @GetMapping("/editar/{idUsuario}")
    public String editar(Usuarios usuario, Model model){
        usuario = usuariosService.encontrarUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "modificar";    
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Usuarios usuario){
        usuariosService.eliminar(usuario);
        return "redirect:/opcionesMenu";
    }
    
    @GetMapping("/detalleOpciones/{idUsuario}")
    public String listaOpciones(Usuarios usuario, Model model){
        
        var opciones = opcionesMenuService.listarOpcionesMenu();
        
        usuario = usuariosService.encontrarUsuario(usuario);

        model.addAttribute("usuario", usuario);
        model.addAttribute("opciones", opciones);
        
        return "modificarOpciones";    
    }
    
    public static String encriptarPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
