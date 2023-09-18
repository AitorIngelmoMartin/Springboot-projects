package com.udemycourse.springboot.web.app.springbootweb;


import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo,@RequestParam Integer numero, Model model) {
        model.addAttribute("titulo","Titulo de params/string");
        model.addAttribute("resultado","El saludo es: '"+saludo+"'y el número es'"+numero+ "'");
        
        return "params/ver";
    }

    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model) {
        String saludo  = request.getParameter("saludo");
        Integer numero = null;
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException e) {
            // TODO: handle exception
        }
        
        model.addAttribute("titulo","Titulo de params/string");
        model.addAttribute("resultado","El saludo es: '"+saludo+"'y el número es'"+numero+ "'");
        
        return "params/ver";
    }
}
