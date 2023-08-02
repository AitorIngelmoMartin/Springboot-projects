package com.udemycourse.springboot.web.app.springbootweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class IndexController {
    //Los metodos siempre van a ser publicos
    
    //@RequestMapping(value = '/index',method=RequestMethod.GET) //Es GET por defecto, pero podemso especificar
    @GetMapping(value = {"/index","","/","/home"})//Esta opción es igual pero especificada
    public String index(Model model){
        model.addAttribute("titulo","Titulo pasado por model");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){

        Usuario usuario = new Usuario();
        usuario.setNombre("Aitor");
        usuario.setApellido("Ingelmo");

        model.addAttribute("usuario",usuario);
        model.addAttribute("titulo","Perfil de: ".concat(usuario.getNombre()));

        return "perfil";
    }
}
