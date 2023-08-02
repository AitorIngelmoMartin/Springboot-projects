package com.udemycourse.springboot.web.app.springbootweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    //Los metodos siempre van a ser publicos
    
    //@RequestMapping(value = '/index',method=RequestMethod.GET) //Es GET por defecto, pero podemso especificar
    @GetMapping(value = {"/index","/home"})//Esta opción es igual pero especificada
    public String index(){
        return "index";
    }
}
