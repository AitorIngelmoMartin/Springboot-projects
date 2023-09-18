package com.udemycourse.springboot.web.app.springbootweb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app") //Esta es la ruta raíz. A partir de esta se accede a las demás
public class IndexController {
    //Los metodos siempre van a ser publicos
    
    //@RequestMapping(value = '/index',method=RequestMethod.GET) //Es GET por defecto, pero podemos especificar
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
        usuario.setEmail("mail_aitor@email.com");

        model.addAttribute("usuario",usuario);
        model.addAttribute("titulo","Perfil de: ".concat(usuario.getNombre()));

        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model){

        List<Usuario> usuarios = new ArrayList<>();
        
        usuarios.add(new Usuario("Aitor","Ingelmo","mail_aitor@email.com"));
        usuarios.add(new Usuario("Samuel","Navarro","mail_samuel@email.com"));
        usuarios.add(new Usuario("Noelia","Dafos","mail_noelia@email.com"));
        model.addAttribute("titulo","Listado de usuarios");
        model.addAttribute("usuarios",usuarios);

        return "listar";
    }
}
