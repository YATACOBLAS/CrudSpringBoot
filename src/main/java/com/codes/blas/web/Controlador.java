package com.codes.blas.web;

import com.codes.blas.domain.Persona;
import com.codes.blas.domain.Rol;
import com.codes.blas.domain.Usuario;
import com.codes.blas.servicio.PersonaServiceImp;
import com.codes.blas.servicio.UsuarioService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Log4j2
public class Controlador {

    @Autowired
    private PersonaServiceImp personaServiceImp;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal User user,Persona persona){
        log.info("usuario :"+ user);
        var personas = personaServiceImp.listarPersona();
        model.addAttribute("mensaje","mensajeando ando desde thymeleaf with Java");
        model.addAttribute("personas",personas);
        model.addAttribute("nombre","Juancho");

        return "index";
    }

    @GetMapping("/registro")
    public String registrar(Usuario usuario){
        return "registro";
    }

    @PostMapping("/registrarUsuario")
    public String registrarUsuario(Usuario usuario){

      usuarioService.registrar(usuario);
     return "redirect:/";
    }

    @GetMapping("/modificar")
    public String modificar(Persona persona){
         return "modificar";

    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        personaServiceImp.guardar(persona);
        return "redirect:/";
    }
    //solo con pasar el id y el aprametro persona, spring buscara en la entidad persona
    //si tiene asociado el attributo de idPersonba automaticamente
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona,Model model){
        persona=personaServiceImp.encontrarPersona(persona);
        model.addAttribute("persona",persona);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaServiceImp.eliminar(persona);
        return "redirect:/";
    }
}
