package com.curso.springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("titulo", "Enviar parametros del request HTTP GET - URL");
        model.addAttribute("titulo2", "Recibir Varios parametros del request HTTP GET - URL");
        model.addAttribute("titulo3", "Recibir Varios parametros del request HTTP GET - URL Con HttpServletRequest");
        
        return "params/index";
    }
    
    @GetMapping("/string")
    //public String params(@RequestParam(name = "texto") Model model
    public String params(@RequestParam(name = "texto", required=false, defaultValue = "Algun Valor") String texto, Model model) {

        model.addAttribute("titulo", "Recibir parametros del request HTTP GET - URL");
        model.addAttribute("resultado", "El texto enviado es :" + texto);

        return "params/ver";
        
    }

    @GetMapping("/mix-params")
    public String params(@RequestParam String saludo, @RequestParam Integer numero, Model model) {

        model.addAttribute("titulo", "Recibir parametros del request HTTP GET - URL");
        model.addAttribute("resultado", "El texto enviado es :" + saludo + " " + numero);

        return "params/ver";
        
    }

    @GetMapping("/mix-params-request")
    public String params(HttpServletRequest request, Model model) throws Exception {
        String saludo = request.getParameter("saludo");
        Integer numero = null;
            try{
                 numero = Integer.parseInt(request.getParameter("numero"));
            }catch(NumberFormatException e){
                 numero = 0;
            }
        model.addAttribute("titulo", "Recibir parametros del request HTTP GET - URL");
        model.addAttribute("resultado", "El texto enviado es :" + saludo + " " + numero);

        return "params/ver";
        
    }
    
}
