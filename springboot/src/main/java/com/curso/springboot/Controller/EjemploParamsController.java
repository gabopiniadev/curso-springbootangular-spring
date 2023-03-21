package com.curso.springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/params")
public class EjemploParamsController {
    
    @GetMapping("/string")
    //public String params(@RequestParam(name = "texto") Model model
    public String params(@RequestParam String texto, Model model) {

        model.addAttribute("titulo", "Recibir parametros del request HTTP GET - URL");
        model.addAttribute("resultado", "El texto enviado es :" + texto);

        return "params/ver";
        
    }
}
