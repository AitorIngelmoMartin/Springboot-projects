package com.udemycourse.springboot.web.app.springbootweb;


import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("titulo","Enviar parámetros del request");
        
        return "params/index";
}

    @GetMapping("/string")
    public String param(@RequestParam(name="texto", required = false) String texto, Model model) {
        model.addAttribute("titulo","Titulo de params/string");
        model.addAttribute("resultado","El texto enviado es: "+texto);
        
        return "params/ver";
    }
}
