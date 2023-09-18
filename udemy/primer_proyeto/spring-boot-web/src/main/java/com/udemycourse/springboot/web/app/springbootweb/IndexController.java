package com.udemycourse.springboot.web.app.springbootweb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        model.addAttribute("titulo","Listado de usuarios");

        return "listar";
    }

    //Esta es otra forma de pasar datos a todas las vistas. Debemos pasar la variable en el '@', el metodo retorna el valor
    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = Arrays.asList(
            new Usuario("Aitor","Ingelmo","mail_aitor@email.com"),
            new Usuario("Samuel","Navarro","mail_samuel@email.com"),
            new Usuario("Noelia","Dafos","mail_noelia@email.com")
            );

        return usuarios;
    }
}
